class Solution {
    
    
    public int compute(int[] dp , int n)
    {
        if(dp[n]!=0 || n==0)
        {
            return dp[n];
        }
        
        dp[n] = compute(dp,n-1)+ compute(dp,n-2) + compute(dp,n-3);
        return dp[n];
    }
    
    
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        
       if(n==0)
           return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        
        int res=compute(dp,n);
        return res;
    }
}
