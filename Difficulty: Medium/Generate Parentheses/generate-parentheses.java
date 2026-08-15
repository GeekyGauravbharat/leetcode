class Solution {
    public ArrayList<String> generateParentheses(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(n % 2 != 0) return ans;
        int pairs = n / 2;
        
        generate(pairs,0,0,"",ans);
        return ans;
        
    }
    public static void generate(int pairs , int l , int r , String s , ArrayList<String> ans){
        if(r == pairs){
            ans.add(s);
            return;
        }
        if(l < pairs) generate(pairs,l+1,r,s+"(",ans);
        if(r < l) generate(pairs,l,r+1,s+")",ans);

    }
}