class Solution {
    
    long[][][] dp;
    long mod = 1000000007;

    public long helper(int n, int k, int m, int max_n, int max_k, int max_m)
    {
        if(n==max_n)
        {
            if(k==max_k)
                return 1l;
            else
                return 0l;
        }
        if(k> max_k)
            return 0l;
        if(dp[n][k][m] != -1l)
            return dp[n][k][m];
        
        long ans = 0l;
        for(int i=1;i<=m ; ++i)
        {
            // No higher element made;
            ans = (ans + helper(n+1,k,m,max_n,max_k,max_m))%mod;
        }

        for(int i=m+1;i<=max_m;++i)
        {
            ans = (ans + helper(n+1,k+1,i,max_n,max_k,max_m))%mod;
        }
        dp[n][k][m] = ans;
        return dp[n][k][m];
    }

    public int numOfArrays(int n, int m, int k) 
    {
        dp = new long[n][k+1][m+1];
        for(int i=0;i<n;++i)
            for(int j=0;j<=k ; ++j)
                Arrays.fill(dp[i][j],-1l);

        long ans = helper(0,0,0,n,k,m);
        return (int) ans;
    }
}
