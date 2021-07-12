class Solution {
    
    int[][] dp ;
    
    public int compute(int sidx, int tidx,String s, String t)
    {
        if(sidx>=s.length() && tidx>=t.length())
            return 1;
        if(tidx>= t.length())
            return 1;
        if(sidx>=s.length())
            return 0;
        
        
        if(dp[sidx][tidx]!=-1)
            return dp[sidx][tidx];
        int ans=0;
        if(s.charAt(sidx)==t.charAt(tidx))
        {
            ans = compute(sidx+1,tidx+1,s,t);
        }
        ans = ans + compute(sidx+1,tidx,s,t);
        dp[sidx][tidx] = ans;
        return ans;
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int [] row: dp)
            Arrays.fill(row,-1);
        return compute(0,0,s,t);
    }
}
