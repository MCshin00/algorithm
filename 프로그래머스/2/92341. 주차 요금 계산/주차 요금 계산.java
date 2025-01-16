import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        Map<String, Integer> inTime = new HashMap<>();
        
        for (String record : records) {
            String[] details = record.split(" ");
            String time = details[0];
            String carNumber = details[1];
            String type = details[2];
            int minutes = convertToMinutes(time);
            
            if (type.equals("IN")) {
                inTime.put(carNumber, minutes);
            } else {
                int parkedMinutes = minutes - inTime.remove(carNumber);
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedMinutes);
            }
        }
        
        for (String carNumber : inTime.keySet()) {
            int parkedMinutes = convertToMinutes("23:59") - inTime.get(carNumber);
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedMinutes);
        }
        
        List<String> carNumbers = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNumbers);
        
        int[] result = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            result[i] = calculateFee(fees, parkingTime.get(carNumber));
        }
        
        return result;
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    private int calculateFee(int[] fees, int totalMinutes) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if (totalMinutes <= basicTime) {
            return basicFee;
        } else {
            int extraTime = totalMinutes - basicTime;
            int extraUnits = (extraTime + unitTime - 1) / unitTime;
            return basicFee + (extraUnits * unitFee);
        }
    }
}