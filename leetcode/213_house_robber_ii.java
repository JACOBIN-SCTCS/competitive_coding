class Solution {

    public int rob(int[] nums) 
    {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        
        int[] dp1  = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        
        return Math.max( nums[0]+ house_robber_i(nums,2,nums.length-2,2,dp1), house_robber_i(nums,1,nums.length-1,1,dp2)  );
    }
    
    public int house_robber_i(int[] nums, int l ,int r,int idx, int[] dp)
    {
        if(idx>r)
            return 0;
        if(dp[idx-l]!=-1)
            return dp[idx-l];
        
        dp[idx-l] = Math.max(nums[idx]+ house_robber_i(nums,l,r,idx+2,dp), house_robber_i(nums,l,r,idx+1,dp));
        return dp[idx-l];
                             
    }
}
