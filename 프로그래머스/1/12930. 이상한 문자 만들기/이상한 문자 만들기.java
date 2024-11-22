class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int cnt = 0;
        
        for (String temp : arr) {
            if (temp.isBlank()) {
                cnt = 0;
            } else {
                cnt++;
            }
            
            if (cnt % 2 == 0) {
                answer += temp.toLowerCase();
            } else {
                answer += temp.toUpperCase();
            }
        }
        
        return answer;
    }
}