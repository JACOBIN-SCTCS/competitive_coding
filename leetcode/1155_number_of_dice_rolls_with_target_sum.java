class Solution {
   
    int mod = 1000000007;
    
    int compute(int d, int f, int target, int idx, int[][] dp)
    {
        
        if(idx>=d && target==0)
            return 1;
        if(idx>=d)
            return 0;
        
        if(target<=0)
            return 0;
        
        if(dp[idx][target]!=-1)
            return dp[idx][target];
        
        int ways=0;
        for(int i=1;i<=f;++i)
        {
            ways =  (ways%mod +(compute(d,f,target-i,idx+1,dp)%mod))%mod;
        }
        dp[idx][target] = ways;
        return dp[idx][target];
    }
    
    
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d][target+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        return compute(d,f,target,0,dp);
    }
}
