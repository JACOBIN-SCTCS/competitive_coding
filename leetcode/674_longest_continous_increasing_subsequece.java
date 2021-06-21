class Solution {
    public int findLengthOfLCIS(int[] nums)
    {
        int ans = 1;
        int i=1; 
        int j =0;
        
        while(i<nums.length)
        {
            if(nums[i]>nums[i-1])
            {
                ans = Math.max(ans,(i-j+1));
                
            }
            else
            {
                j=i;
            }
            i+=1;
        }
        return ans;
    }
}
