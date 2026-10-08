class Solution {
    private static final long MOD = 1_000_000_007L;

    // returns {F(k), F(k+1)} modulo MOD
    private long[] fib(long k) {
        if (k == 0) return new long[]{0, 1};
        long[] h = fib(k >> 1);
        long a = h[0], b = h[1];
        long c = a * (((2 * b - a) % MOD + MOD) % MOD) % MOD; // F(2m)
        long d = (a * a + b * b) % MOD;                       // F(2m+1)
        if ((k & 1) == 0) return new long[]{c, d};
        return new long[]{d, (c + d) % MOD};
    }

    public int countGoodStrings(long n) {
        return (int) (2 * fib(n)[0] % MOD);
    }
}