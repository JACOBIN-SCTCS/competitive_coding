class Solution {
    
    int[][] dp ;
    
    public int helper(String s , int start, int end)
    {
        if(start>=end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        
        if(s.charAt(start)==s.charAt(end))
        {
            
            int ans = helper(s,start+1,end-1);
            dp[start][end] = ans;
        }
        else
        {
            int ans1 = 1 + helper(s,start+1,end);
            int ans2 = 1 + helper(s,start,end-1);
            int ans = Math.min(ans1,ans2);
            dp[start][end] = ans;
        }
        return dp[start][end];
    }
    public int minInsertions(String s) 
    {
        int n = s.length();
        dp = new int[n][n];
        for(int i=0;i<n;++i)
            Arrays.fill(dp[i],-1);
        int ans = helper(s,0,s.length()-1);
        return ans;
    }
}
