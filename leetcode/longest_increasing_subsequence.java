class Solution 
{
    public int lengthOfLIS(int[] nums)
    {
        int[] length = new int[nums.length];
        int max_val=-1;
        
        
        for(int i=0; i<nums.length;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(nums[j]<nums[i])
                    length[i] = Math.max(length[i], length[j]+1);
            }
            max_val = Math.max(max_val,length[i]);
        }
        return max_val+1;
    
    }
}
