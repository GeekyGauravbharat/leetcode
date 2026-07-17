class Solution {
    public int gcdOfOddEvenSums(int n) {
        long sumOdd = (long) n * n;              // 1+3+...+(2n-1) = n^2
        long sumEven = (long) n * (n + 1);       // 2+4+...+2n = n(n+1)
        return (int) gcd(sumOdd, sumEven);
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}