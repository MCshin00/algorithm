class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            int tempLen = s.length();
            s = s.replaceAll("0", "");
            
            answer[0]++;
            answer[1] += (tempLen - s.length());
            
            s = Integer.toBinaryString(s.length());
        }
        
        return answer;
    }
}