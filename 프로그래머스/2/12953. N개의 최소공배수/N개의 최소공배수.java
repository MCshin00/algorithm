class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        if (arr.length == 1) {
            return answer;
        }
        
        for (int i=1; i<arr.length; i++) {
            answer = getLcm(answer, arr[i]);
        }
        
        
        return answer;
    }
    
    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
    
    private static int getGcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        
        return getGcd(b, r);
    }
}