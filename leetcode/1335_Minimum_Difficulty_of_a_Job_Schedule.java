class Solution {
    
    int[][] dp;
    
    public int helper(int idx, int days_remaining , int[] jobDifficulty)
    {
        // Had to refer a solution for the base condition.
        if(days_remaining == 0 && idx == jobDifficulty.length )
            return 0;
        if(days_remaining == 0 || idx == jobDifficulty.length )
            return Integer.MAX_VALUE;
        


        if(dp[idx][days_remaining] != -1)
            return dp[idx][days_remaining];
        
        int ans = Integer.MAX_VALUE;
        int max = jobDifficulty[idx];

        for(int i=idx; i < jobDifficulty.length;++i)
        {
            int remaining = helper(i+1,days_remaining-1,jobDifficulty);
            max = Math.max(max,jobDifficulty[i]);
            if(remaining != Integer.MAX_VALUE)
                ans = Math.min(ans , max + remaining);
               
        }
        dp[idx][days_remaining] = ans ;
        return ans;
    }

    public int minDifficulty(int[] jobDifficulty, int d) 
    {
        int n = jobDifficulty.length;

        if( n < d)
            return -1;
        
        dp = new int[n][d+1];
        
        for(int i=0;i<n;++i)
            Arrays.fill(dp[i],-1);
        
        int ans = helper(0,d,jobDifficulty);
        return ans;
    }
}
