class Solution {
    public ArrayList<String> powerSet(String s) {
       ArrayList<String> list = new ArrayList<>();
       Subsets("",s,0,list);
       Collections.sort(list);
       return list;
        
    }
    public static void Subsets(String ans ,String s  ,int idx ,List<String> list){
        if(idx==s.length()){
            list.add(ans);
            return ;
        }
        char ch = s.charAt(idx);
        Subsets(ans+ch,s,idx+1,list);
        Subsets(ans,s,idx+1,list);

    }
}
