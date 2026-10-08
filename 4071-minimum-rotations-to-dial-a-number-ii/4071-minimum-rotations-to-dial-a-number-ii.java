class Solution {
    private int dist(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }

    public int minRotations(int n, String s) {
        // pre[i] = cost to dial the first i characters starting from 0
        int[] pre = new int[n + 1];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            pre[i + 1] = pre[i] + dist(pos, d);
            pos = d;
        }

        // inner[i] = sum of dist(s[j], s[j+1]) for j < i
        int[] inner = new int[n];
        for (int i = 1; i < n; i++) {
            inner[i] = inner[i - 1] + dist(s.charAt(i - 1) - '0', s.charAt(i) - '0');
        }

        int last = s.charAt(n - 1) - '0';
        int best = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            int p = (k == 0) ? 0 : s.charAt(k - 1) - '0';
            // dial prefix, jump to s[n-1] (the start of the reversed suffix),
            // then walk through the suffix (same cost in either direction)
            int cost = pre[k] + dist(p, last) + (inner[n - 1] - inner[k]);
            best = Math.min(best, cost);
        }
        return best;
    }
}