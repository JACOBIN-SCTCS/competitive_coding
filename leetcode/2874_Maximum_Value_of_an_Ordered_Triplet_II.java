class Solution {
    public long maximumTripletValue(int[] nums) {
        // Referred hints
        int n = nums.length;
        int[] prefixMax = new int[nums.length];
        int[] suffixMax = new int[nums.length];
        prefixMax[0] = nums[0];
        suffixMax[n-1] = nums[n-1];


        for(int i=1 ; i < nums.length; ++i)
        {
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
            suffixMax[n-1-i] = Math.max(suffixMax[n-i],  nums[n-i-1]);
        }
        long ans = 0;
        for(int i=1; i < n-1; ++i)
        {
            long current = ((long)(prefixMax[i-1] - nums[i]) * suffixMax[i+1]);
            ans = Math.max(ans, current);
        }
        return ans;

    }
}
