class Solution {
    public long zeroFilledSubarray(int[] nums) 
    {
        long ans = 0;
        long prev = 0;
        for(int i =0; i< nums.length;++i)
        {   
            if(nums[i]==0)
            {
                ans = ans + (prev+1);
                prev+=1;
            }
            else
            {
                prev = 0;
            }
        }   
        return ans;
    }
}
