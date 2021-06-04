class Solution {
    public int minPairSum(int[] nums) 
    {
        Arrays.sort(nums);
        int output = 0;
        
        for(int i=0;i<(nums.length/2);++i)
        {
            output = Math.max(output, nums[i] + nums[nums.length-1-i]);
        }
        return output;
    }
}
