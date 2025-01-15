class Solution {
    public int solution(int n, int k) {
        String kNumber = convertToBase(n, k);
        String[] numbers = kNumber.split("0");
        int count = 0;
        
        for (String num : numbers) {
            if (num.length() > 0 && isPrime(Long.parseLong(num))) {
                count++;
            }
        }
        
        return count;
    }
    
    private String convertToBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }
    
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}