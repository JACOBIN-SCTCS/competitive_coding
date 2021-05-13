class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans =0;
        for(int i=nums.length-2;i>=0;i-=2)
        {
            ans+= Math.min(nums[i],nums[i+1]);
        }
        return ans;
    }
}
