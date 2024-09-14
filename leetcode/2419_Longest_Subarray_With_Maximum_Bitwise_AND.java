class Solution {
    public int longestSubarray(int[] nums) 
    {

        int length = 0;
        int max_element =0;
        int ans = 1;

        for(int i=0; i < nums.length; ++i)
        {
            if(max_element < nums[i])
            {
                max_element = Math.max(max_element,nums[i]);
                ans = length=0;
            }
            
            if(max_element == nums[i])
            {
                length+=1;
            }
            else
            {
                length=0;
            }
            ans = Math.max(ans,length);
            
        }
        return ans;
    }
}
