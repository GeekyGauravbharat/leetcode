class Solution {
    public int minRotations(String s) {
        int pos = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            int diff = Math.abs(d - pos);
            total += Math.min(diff, 10 - diff);
            pos = d;
        }
        return total;
    }
}