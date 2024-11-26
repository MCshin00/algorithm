import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        int[] temp = {};
        
        for (int i=0; i<commands.length; i++){
            temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer.add(temp[commands[i][2]-1]);
        }
        
        return answer;
    }
}