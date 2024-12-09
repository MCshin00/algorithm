import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for (int i=0; i<type.length; i++) {
            map.put(type[i], 0);
        }
        
        for (int i=0; i<survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            
            if (choices[i] == 4) {
                continue;
            }
            
            if (choices[i] < 4) {
                map.put(first, map.get(first) + (4 - choices[i]));
            } else {
                map.put(second, map.get(second) + (choices[i] - 4));
            }
            
        }
        
        for (int i = 0; i < type.length; i += 2) {
            char left = type[i];
            char right = type[i + 1];

            if (map.get(left) >= map.get(right)) {
                sb.append(left);
            } else {
                sb.append(right);
            }
        }
        
        return sb.toString();
    }
}