class Solution {
    public int longestOnes(int[] nums, int k)
    {
        int left=0;
        int right=0;
        int number_of_zeros=0;
        int ans =0;
        
        while(right<nums.length)
        {
            number_of_zeros = number_of_zeros + ((nums[right]==0)?1:0);
            while(number_of_zeros>k)
            {
                number_of_zeros = number_of_zeros - ((nums[left]==0?1:0));
                left++;
            }
            ans = Math.max(ans,right-left+1);
            right+=1;
        }
        return ans;
        
    }
}
