class Solution {
    public String solution(String s, int n) {
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (Character.isLowerCase(arr[i])) {
                    arr[i] = (char) ('a' + (arr[i] - 'a' + n) % 26);
                } else {
                    arr[i] = (char) ('A' + (arr[i] - 'A' + n) % 26);
                }
            }
        }
        
        return String.valueOf(arr);
    }
}