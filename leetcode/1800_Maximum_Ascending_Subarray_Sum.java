class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int[] values = new int[nums.length];
        
        ans = nums[0];
        values[0] = nums[0];

        for(int i=1; i < nums.length; ++i)
        {
            if(nums[i] <= nums[i-1])
            {
                values[i] = nums[i];
            }
            else
            {
                values[i] = values[i-1] + nums[i];
            }
            ans = Math.max(ans,values[i]);
        }
        return ans;

    }
}
