class Solution {
   
    public int compute(int[] nums, int left, int right,int[][] dp)
    {
        if(left+1==right)
            return 0;
        if(dp[left][right]!=0)
            return dp[left][right];
        
        for(int i=left+1;i<right;++i)
        {
            dp[left][right] = Math.max(dp[left][right], nums[i]*nums[left]*nums[right]+ compute(nums,left,i,dp)
                                    + compute(nums,i,right,dp)
                                 );
        }
        return dp[left][right];
    }
    
    public int maxCoins(int[] nums)
    {
        int[] arr = new int[nums.length+2];
        for(int i=0;i<nums.length;++i)
        {
            arr[i+1] = nums[i];
        }
        arr[0]=1; arr[arr.length-1]=1;
        int[][] dp = new int[arr.length][arr.length];
        return compute(arr,0,arr.length-1,dp);
        
         
    }
}
