public class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean isStartOfWord = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append(c);
                isStartOfWord = true;
            } else if (isStartOfWord) {
                result.append(Character.toUpperCase(c));
                isStartOfWord = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }
}