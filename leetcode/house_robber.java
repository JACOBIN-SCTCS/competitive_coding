class Solution {
   
    public int computePrice(int[] dp , int[] nums,int idx)
    {
        
        if(idx>=nums.length)
            return 0;
        
        if(dp[idx]!=-1)
            return dp[idx];
        
        dp[idx] = Math.max( nums[idx]+computePrice(dp,nums,idx+2) , computePrice(dp,nums,idx+1));
        return dp[idx];
        
    }
    public int rob(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return computePrice(dp,nums,0);
        
    }
}
