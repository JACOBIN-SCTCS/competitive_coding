class Solution {
    public int minMoves2(int[] nums) 
    {
        Arrays.sort(nums);
        int ans=0;
        for(int n:nums)
        {
            ans+= Math.abs(n- nums[nums.length/2]);
        }
        return ans;
    }
}
