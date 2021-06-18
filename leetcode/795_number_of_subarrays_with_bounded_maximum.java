class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) 
    {
        int ans = 0 ;
        
        int start = 0;
        int end = 0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]>=left && nums[i]<=right)
            {
                end = (i-start)+1;            
            }
            else if(nums[i]>right)
            {
                end = 0 ;
                start = i+1;
            }
            ans += end;
        }
        return ans;
    }
}
