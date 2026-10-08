class Solution {
    public long maxAlternatingSum(int[] nums) {
        final long NEG = Long.MIN_VALUE / 4;

        // Best alternating sum of a subarray whose last kept element is the current one
        // (or, for the deletion states, possibly the previous one if the current is deleted):
        //   noDelEven / noDelOdd = no deletion used, last kept element at even / odd index
        //   delEven   / delOdd   = deletion used,    last kept element at even / odd index
        long noDelEven = NEG, noDelOdd = NEG;
        long delEven = NEG, delOdd = NEG;
        long ans = NEG;

        for (int v : nums) {
            long x = v;

            // x kept at an even index: start fresh, or extend from an odd index
            long newNoDelEven = Math.max(x, noDelOdd == NEG ? NEG : noDelOdd + x);
            // x kept at an odd index: extend from an even index
            long newNoDelOdd = noDelEven == NEG ? NEG : noDelEven - x;

            // same transitions with a deletion already used,
            // or delete x right now (carry the no-deletion state over unchanged)
            long newDelEven = Math.max(x, delOdd == NEG ? NEG : delOdd + x);
            newDelEven = Math.max(newDelEven, noDelEven);

            long newDelOdd = delEven == NEG ? NEG : delEven - x;
            newDelOdd = Math.max(newDelOdd, noDelOdd);

            noDelEven = newNoDelEven;
            noDelOdd = newNoDelOdd;
            delEven = newDelEven;
            delOdd = newDelOdd;

            ans = Math.max(ans, Math.max(Math.max(noDelEven, noDelOdd),
                                         Math.max(delEven, delOdd)));
        }
        return ans;
    }
}