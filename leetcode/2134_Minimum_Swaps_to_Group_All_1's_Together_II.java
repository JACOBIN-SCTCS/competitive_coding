class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for(int i=0;i<nums.length;++i)
        {
            ones += nums[i];
        }

        if(ones ==0 || ones == nums.length)
            return 0;
        
        int sliding_ones = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i < ones; ++i)
        {
            sliding_ones += nums[i];
        }

        ans = Math.min(ans, ones - sliding_ones);
        for(int i=0; i < nums.length;++i)
        {
            sliding_ones = sliding_ones - nums[i];
            sliding_ones = sliding_ones + (nums[(i+ones)%nums.length]);
            ans = Math.min(ans, ones - sliding_ones);
        }

        return ans;
    }
}
