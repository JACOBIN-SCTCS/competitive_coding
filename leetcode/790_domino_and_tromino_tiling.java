class Solution {
    
    long[][] dp;
    long mod = 1000000007;;
    
    public long compute(int top, int bottom, int n)
    {
        
        if(top==n && bottom==n)
            return 1l;
        if(top>n || bottom > n)
            return 0l;
        
        if(dp[top][bottom]!=-1l)
            return dp[top][bottom];
        
        
        if(top==bottom)
        {
            dp[top][bottom] =  ((compute(top+2,bottom+1,n) + compute(top+1,bottom+1,n))%mod
                + (compute(top+2,bottom+2,n) + compute(top+1,bottom+2,n))%mod)%mod;
            return dp[top][bottom];
        }
        else if(Math.abs(top-bottom)>=2)
        {
            if(top>bottom)
            {
                dp[top][bottom] = compute(top,bottom+2,n);
            }
            else
            {
                dp[top][bottom]=compute(top+2,bottom,n);
            }
        }
        else
        {
            if(top>bottom)
            {
                dp[top][bottom] = (compute(top+1,bottom+2,n) + compute(top,bottom+2,n))%mod;   
            }
            else
            {
                dp[top][bottom] = (compute(top+2,bottom+1,n) + compute(top+2,bottom,n))%mod;
            }
        }
        return dp[top][bottom];
    }

    public int numTilings(int n) 
    {
        dp = new long[n+1][n+1];
        for(long[] row:dp)
            Arrays.fill(row,-1l);
        
        return (int)compute(0,0,n);
    }
}
