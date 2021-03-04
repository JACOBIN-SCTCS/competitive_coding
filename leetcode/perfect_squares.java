class Solution 
{
    public int numSquares(int n)
    {
        int[] dp = new int[n+1];
        
        for(int i=1;i<n+1;++i)
            dp[i]=i;
        
        
        int square_limit = (int)Math.sqrt(n);
        int[] squares = new int[square_limit];
        
        for(int i=1;i<=square_limit;++i)
        {
            squares[i-1] = i*i;
        }
        
        for(int square: squares)
        {
            for(int i=square;i<=n;++i)
            {
                dp[i] = Math.min(dp[i],1+dp[i-square]);
            }
        }
        
        return dp[n];
        
    }
}
