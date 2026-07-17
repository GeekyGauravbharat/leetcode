class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reversed = 0, original = x;
        while (x > 0) {
            int digit = x % 10;
            if (reversed > Integer.MAX_VALUE / 10) return false;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed == original;
    }
}