class Solution {
    
    long[] dp;
    long mod = 1000000007;
    
    public long helper(int n)
    {
        if(n==1)
            return 1l;
        if (dp[n] != -1l)
            return dp[n];

        long ans = 1;
        long temp = n*(2*n-1);
        ans = (temp*helper(n-1))%mod;
        dp[n] = ans;
        return ans;

    }

    public int countOrders(int n) {
        dp = new long[n+1];

        Arrays.fill(dp,-1l);
        long ans = helper(n);
        return (int) ans;

    }
}
