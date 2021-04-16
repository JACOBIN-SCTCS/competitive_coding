class Solution {
    
    public int compute(int n, int[] dp)
    {
        if(n<=0)
            return 0;
        
        if(n>0 && dp[n]!=0)
            return dp[n];
        
        dp[n] = compute(n-1,dp)+compute(n-2,dp);
        return dp[n];
    }
    
    public int fib(int n) 
    {
            int[] dp = new int[n+1];
            if(n==0)
                return 0;
            if(n==1)
                return 1;
        
            dp[0]=0;
            dp[1]=1;
            return compute(n,dp);
    }
}
