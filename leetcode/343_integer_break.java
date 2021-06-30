class Solution {
    public int integerBreak(int n) 
    {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3;i<=n;++i)
        {
            for(int j=1;j<i;++j)
            {
                dp[i] = Math.max(dp[i],j*dp[i-j]);
                dp[i] = Math.max(dp[i],j*(i-j));
            }
        }
        return dp[n];
        
    }
}
