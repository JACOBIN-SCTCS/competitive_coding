class Solution {
    public boolean canPartition(int[] nums) 
    {
        int sum=0;
         for(int num : nums)
             sum+=num;
        
        if(sum%2==1)
            return false;
        
        int required = sum/2;
        boolean[][] dp = new boolean[nums.length+1][required+1];
        
        for(int i=0;i<=nums.length;++i)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<=required;++i)
            dp[0][i]=false;
        
        for(int i=1;i<=nums.length;++i)
        {
            for(int j=1;j<=required;++j)
            {
                if(j>= nums[i-1])
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][required];
        
        
    }
    
    
}
