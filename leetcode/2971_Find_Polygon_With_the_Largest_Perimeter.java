class Solution {
    public long largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);

        long ans = -1;
        long sum = nums[0] + nums[1];
        
        int i=2;
        for(; i < nums.length; ++i)
        {
           if(sum > nums[i])
                ans = sum + nums[i];
           sum = sum + nums[i];
           
        }
       
        return ans;
    }
}
