class Solution {
    public long solution(int n) {
        long prev1 = 1;
        long prev2 = 2;
        
        if (n == 1) return prev1;
        if (n == 2) return prev2;

        for (int i = 3; i <= n; i++) {
            // 점화식 f(n) = f(n-1) + f(n-2)
            long current = (prev1 + prev2) % 1234567;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}