class Solution {  
    int answer = 0;  
  
    public int solution(int[] numbers, int target) {  
        dfs(0, numbers, target, 0);  
        return answer;  
    }  
  
    private void dfs(int depth, int[] numbers, int target, int result) {  
        if (depth == numbers.length) {  
            if (result == target) {  
                answer++;  
            }  
            return;  
        }  
        dfs(depth + 1, numbers, target, result + numbers[depth]);  
        dfs(depth + 1, numbers, target, result - numbers[depth]);  
    }
}