import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        int bridge_weight = 0;
        
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        
        while(index < truck_weights.length) {
            bridge_weight -= q.poll();
            if(bridge_weight + truck_weights[index] <= weight) {
                bridge_weight += truck_weights[index];
                q.offer(truck_weights[index++]);
            }
            else q.offer(0);
            
            answer++;
        }
        
        return bridge_length + answer;
    }
}