import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i=0; i<answers.length; i++) {
            if(answers[i] == first[i%5]) {
                answer[0]++;
            }
            if(answers[i] == second[i%8]) {
                answer[1]++;
            } 
            if(answers[i] == third[i%10]) {
                answer[2]++;
            }
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == answer[i]) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}