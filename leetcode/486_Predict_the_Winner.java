class Solution 
{
    int[][] dp;

    public int helper(int[] nums,int left, int right)
    {   
        if(left>right)
            return 0;
        if(dp[left][right]!=-1)
            return dp[left][right];
        
        int ans = nums[left]  - helper(nums,left+1,right);
        ans = Math.max(ans, nums[right] - helper(nums,left,right-1));
        dp[left][right] = ans;
        return ans;
    }
    public boolean PredictTheWinner(int[] nums) 
    {
        int n = nums.length;
        dp = new int[n][n];
        for(int i=0;i<n;++i)
            Arrays.fill(dp[i],-1);
        int difference = helper(nums,0,nums.length-1);

        if(difference>=0)
            return true;
        else
            return false;
    }
}
