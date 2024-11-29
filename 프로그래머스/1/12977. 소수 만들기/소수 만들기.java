import java.lang.Math;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if (checkPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    private boolean checkPrime(int sum) {
        for (int i=2; i<=(int)Math.sqrt(sum); i++) {
            if (sum % i == 0) return false;
        }
        
        return true;
    }
}