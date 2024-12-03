class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            int idx = X.charAt(i) - '0';
            xArr[idx]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int idx = Y.charAt(i) - '0';
            yArr[idx]++;
        }
        
        for (int i= 9; i >= 0; i--) {
            while (xArr[i] > 0 && yArr[i] > 0) {
                xArr[i]--;
                yArr[i]--;
                answer.append(i);
            }
        }
        
        if (answer.toString().equals("")) return "-1";
        
        if (answer.toString().startsWith("0")) return "0";
        
        return answer.toString();
    }
}