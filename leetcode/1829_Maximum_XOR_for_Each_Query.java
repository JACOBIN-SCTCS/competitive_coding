class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        
        int[] ans = new int[nums.length];
        int prefix = 0;
        
        int max_value = (int) Math.pow(2,maximumBit)-1;
        for(int i=0; i < nums.length; ++i)
        {
            prefix = prefix ^ nums[i];
            ans[ans.length-1-i] = prefix ^ max_value; 
        }
        return ans;
    }
}
