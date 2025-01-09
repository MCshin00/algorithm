import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int date = ((int)Math.ceil((100.0-progresses[i])/speeds[i]));
            
            if(!q.isEmpty() && q.peek() < date){
                answer.add(q.size());
                q.clear();
            }
            
            q.add(date);
        }
        
        answer.add(q.size());
            
        return answer;
    }
}