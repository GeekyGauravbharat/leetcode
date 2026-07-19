class Solution {
    
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int m = r - l + 1;
        int s = 2 * m;
        
        long[] x2 = new long[s];
        for (int v = 0; v < m; v++) {
            x2[v] = v;
            x2[m + v] = m - 1 - v;
        }
        
        if (n == 2) {
            long total = 0;
            for (long val : x2) total = (total + val) % MOD;
            return (int) total;
        }
        
        long[][] M = new long[s][s];
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++) {
                M[v][m + u] = 1;
            }
            for (int u = v + 1; u < m; u++) {
                M[m + v][u] = 1;
            }
        }
        
        long exponent = n - 2;
        long[][] Mp = matrixPower(M, exponent, s);
        long[] result = multiplyVector(Mp, x2, s);
        
        long total = 0;
        for (long val : result) total = (total + val) % MOD;
        return (int) total;
    }
    
    private long[][] matrixPower(long[][] base, long exp, int s) {
        long[][] result = identity(s);
        long[][] b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, b, s);
            }
            b = multiply(b, b, s);
            exp >>= 1;
        }
        return result;
    }
    
    private long[][] identity(int s) {
        long[][] id = new long[s][s];
        for (int i = 0; i < s; i++) id[i][i] = 1;
        return id;
    }
    
    private long[][] multiply(long[][] a, long[][] b, int s) {
        final int MOD = 1_000_000_007;
        long[][] c = new long[s][s];
        for (int i = 0; i < s; i++) {
            for (int k = 0; k < s; k++) {
                if (a[i][k] == 0) continue;
                long aik = a[i][k];
                for (int j = 0; j < s; j++) {
                    c[i][j] = (c[i][j] + aik * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }
    
    private long[] multiplyVector(long[][] a, long[] v, int s) {
        final int MOD = 1_000_000_007;
        long[] c = new long[s];
        for (int i = 0; i < s; i++) {
            long sum = 0;
            for (int j = 0; j < s; j++) {
                sum = (sum + a[i][j] * v[j]) % MOD;
            }
            c[i] = sum;
        }
        return c;
    }
}