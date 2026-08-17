class Solution {
    int factorial(int n) {
        if(n==0 || n==1) return 1;
        int ans= n*factorial(n-1);
        return ans;
        
    }
}
