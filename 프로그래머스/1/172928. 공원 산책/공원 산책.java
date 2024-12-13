class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;
        
        char[][] arr = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++){
            arr[i] = park[i].toCharArray();
            
            if(park[i].contains("S")){
                startY = i;
                startX = park[i].indexOf("S");
            }
        }
    
        for(String route : routes){
            String way = route.split(" ")[0];
            int len = Integer.parseInt(route.split(" ")[1]);
            
            int currentX = startX;
            int currentY = startY;
            
            for(int i = 0; i < len; i++){
                if(way.equals("E")){
                    currentX++;
                }
                if(way.equals("W")){
                    currentX--;
                }
                if(way.equals("S")){
                    currentY++;
                }
                if(way.equals("N")){
                    currentY--;
                }
                if(currentX >=0 && currentY >=0 && currentY < arr.length && currentX < arr[0].length){
                    if(arr[currentY][currentX] == 'X'){
                        break;
                    }

                    if(i == len-1){
                        startX = currentX;
                        startY = currentY;
                    }
                }
            }
        }       
        
        int[] answer = {startY, startX};
        return answer;
    }
}