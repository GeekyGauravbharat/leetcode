class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = arr.length , n = arr[0].length;
        int fr =0, lc=n-1 , lr =m-1 , fc = 0;
        while(fr <= lr && fc <= lc){
            for(int j = fc;j <= lc;j++)
            ans.add(arr[fr][j]);
            fr++;
            if(fr>lr || fc>lc) break;
            
            for(int i = fr;i <= lr;i++)
            ans.add(arr[i][lc]);
            lc--;
            if(fr>lr || fc>lc) break; 
            
            for(int j = lc;j >= fc;j--)
            ans.add(arr[lr][j]);
            lr--;
            if(fr>lr || fc>lc) break;
            
            for(int i = lr;i >= fr;i--)
            ans.add(arr[i][fc]);
            fc++;
            
            
        }
        return ans;
        
    }
}
