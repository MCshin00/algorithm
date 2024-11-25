import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<String> strList = new ArrayList<>();
        
        for (int i=0; i<strings.length; i++) {
            strList.add(String.valueOf(strings[i].charAt(n)) + strings[i]);
        }
        
        Collections.sort(strList);
        answer = new String[strList.size()];
        
        for (int i=0; i<strList.size(); i++) {
            answer[i] = strList.get(i).substring(1, strList.get(i).length());
        }
        
        return answer;
    }
}