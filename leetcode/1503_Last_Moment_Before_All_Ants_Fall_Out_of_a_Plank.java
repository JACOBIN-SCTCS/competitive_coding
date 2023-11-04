class Solution {
    public int getLastMoment(int n, int[] left, int[] right) 
    {
        // Had to refer hint
        int ans = 0;
        for(int i=0;i<left.length;++i)
        {
            ans = Math.max(ans,Math.abs(0-left[i]));
        }    
        for(int i=0;i<right.length;++i)
        {
            ans = Math.max(ans,Math.abs(n-right[i]));
        }
        return ans;
    }
}
