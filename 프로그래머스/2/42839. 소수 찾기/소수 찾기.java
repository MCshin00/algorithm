import java.util.*;

class Solution {
    static int answer = 0;
    static HashSet<Integer> nums = new HashSet<>();
    static int[] check = {};
    
    public int solution(String numbers) {
        check = new int[numbers.length()];
        
        dfs(numbers, check, "");
        
        for(int num : nums){
            primeNumber(num);
        }
        
        return answer;
    }
    
    static void dfs(String numbers, int[] check, String temp) {
        
        if (temp.length() >= 1){
            int tempNum = Integer.parseInt(temp);
            nums.add(tempNum);
        }
        
        for (int i=0; i<numbers.length(); i++){
            if (check[i] == 0){
                check[i] = 1;
                temp += numbers.charAt(i);
                dfs(numbers, check, temp);
                temp = temp.substring(0, temp.length()-1);
                check[i] = 0;
            }
        }
    }
    
    static void primeNumber(int n){
        if(n == 0) return;
        if(n == 1) return;
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0) return;
        }
        
        answer++;
    }
}