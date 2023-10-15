class Solution 
{
    int[][] dp;    
    int mod = 1000000007;

    public int helper(int steps, int pos, int arrLen)
    {
        if(steps==0)
        {
            if(pos==0)
                return 1;
            else
                return 0;
        }

        if(pos < 0 || pos >= arrLen)
            return 0;

        if(dp[steps][pos] != -1)
            return dp[steps][pos];
        
        int[] next_steps = new int[]{-1,0,1};
        int ans = 0;

        for(int step : next_steps)
        {
            int new_pos = pos + step;
            if(new_pos >=0 && new_pos < arrLen)
            {
                ans = (ans + helper(steps-1,new_pos,arrLen))%mod;
            }
        }
        dp[steps][pos] = ans;
        return ans;
    }

    public int numWays(int steps, int arrLen) 
    {
        // Had to refer the second hint for line 40
        arrLen = Math.min(steps,arrLen);
        dp  = new int[steps+1][arrLen];
        for(int i=0; i<= steps; ++i)
            Arrays.fill(dp[i],-1);
        return helper(steps,0,arrLen);
        
    }
}
