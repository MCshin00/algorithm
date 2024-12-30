import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (isValid(rotated)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if ((c == ')' && stack.peek() != '(') ||
                       (c == ']' && stack.peek() != '[') ||
                       (c == '}' && stack.peek() != '{')) {
                return false;
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}