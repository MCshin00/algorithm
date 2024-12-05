import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> keypad = new HashMap<>();
        
        for (int i=0; i<keymap.length; i++) {
            for (int j=0; j<keymap[i].length(); j++) {
                char key = keymap[i].charAt(j);
                int value = keypad.getOrDefault(key, j+1);
                
                keypad.put(key, Math.min(value, j+1));
            }
        }
        
        for (int i=0; i<targets.length; i++) {
            for (int j=0; j<targets[i].length(); j++) {
                char key = targets[i].charAt(j);
                
                if (keypad.containsKey(key)) {
                    answer[i] += keypad.get(key);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}