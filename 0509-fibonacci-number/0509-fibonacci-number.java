class Solution {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int first =0 , second =1;
        for(int i= 1 ; i<=n ; i++){
            int next = first +second;
            first =second;
            second = next;
           
        }
        return first;
    }

}