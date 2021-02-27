class Solution {
public:
    
    long dp[20];
    
    int recurrence(int n)
    {
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
        dp[n]=0;
        
        for(int i=0;i<n;++i)
        {
            dp[n] += recurrence(n-1-i)*recurrence(i);
            
        }
        return dp[n];
          
    }
    
    
    
    int numTrees(int n)
    {
        dp[0]=1;
        dp[1]=1;
        
        return recurrence(n);
        
    }
};
