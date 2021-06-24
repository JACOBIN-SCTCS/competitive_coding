class Solution {
    
    long mod = 1000000007;
    long [][][] dp;
    
    
    
    public long compute(int m, int n, int maxMove, int sr, int sc)
    {
        if(maxMove<0)
            return 0l;
        if(sr<0 || sr>=m||sc<0||sc>=n)
        {
            return 1l;
        }
        
        if(dp[maxMove][sr][sc]!=-1)
            return dp[maxMove][sr][sc];
        
        long ans = 0l;
        long left = compute(m,n,maxMove-1,sr,sc-1);
        long right = compute(m,n,maxMove-1,sr,sc+1);
        long up    = compute(m,n,maxMove-1,sr-1,sc);
        long down = compute(m,n,maxMove-1,sr+1,sc);
        
        ans = (ans+left)%mod;
        ans = (ans+right)%mod;
        ans = (ans+up)%mod;
        ans = (ans+down)%mod;
        dp[maxMove][sr][sc] = ans%mod;
        
        return dp[maxMove][sr][sc];
        
    }
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        dp = new long[maxMove+1][m][n];
        for(int i=0;i<=maxMove;++i)
        {
            for(int j=0;j<m;++j)
            {
                Arrays.fill(dp[i][j],-1l);
            }
        }
        return (int)compute(m,n,maxMove,startRow,startColumn);
        
    }
}
