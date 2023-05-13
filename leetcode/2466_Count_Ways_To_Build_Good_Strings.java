class Solution 
{
    int mod = 1000000007;
    int[] dp;

    public int helper(int idx, int zero, int one)
    {
        if(idx<0)
            return 0;
        if(idx==0)
            return 1;
        if(dp[idx]!=-1)
            return dp[idx];
        
        int ans = 0;
        ans = (ans + helper(idx-zero,zero,one))%mod;
        ans = (ans + helper(idx-one,zero,one))%mod;
        dp[idx] = ans;
        return ans;
    }

    public int countGoodStrings(int low, int high, int zero, int one) 
    {
        dp = new int[high+1];
        Arrays.fill(dp,-1);

        int ans = 0;
        for(int i=low;i<=high;++i)
        {
            ans = (ans + helper(i,zero,one))%mod;
        }
        
        return ans;
    }
}
