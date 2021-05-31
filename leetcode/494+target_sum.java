class Solution {
    
    public int compute(int[] nums, int idx, int target, int sum, int[][] dp)
    {
        if(idx==nums.length)
        {
            if(sum==target)
                return 1;
            else
                return 0;
        }
        if(dp[idx][sum+1000]!=Integer.MAX_VALUE)
            return dp[idx][sum+1000];
        
        int incl = compute(nums,idx+1,target,sum+nums[idx],dp);
        int sub  = compute(nums,idx+1,target,sum-nums[idx],dp);
        dp[idx][sum+1000] = incl + sub;
        return dp[idx][sum+1000];
    }
    
    public int findTargetSumWays(int[] nums, int target)
    {
        int[][] dp = new int[nums.length][2001];
        for(int[] row:dp)
            Arrays.fill(row,Integer.MAX_VALUE);
        return compute(nums,0,target,0,dp);
        
    }
}
