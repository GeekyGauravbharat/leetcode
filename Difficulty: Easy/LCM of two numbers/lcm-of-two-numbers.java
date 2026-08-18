class Solution {
    public int lcm(int a, int b) {
        // code here
        int ans = a / gcd(a, b) * b;
        return ans;
    }
    public static int gcd(int a, int b) {
       if(a==0) return b ;
        return gcd(b%a,a);
}
}