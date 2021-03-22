class Solution 
{
     
    public int findNumberOfLIS(int[] nums) 
    {
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(length,1);
        
        
        for(int i=0;i<nums.length;++i)
        {
            int max_length=1;
            
            for(int j=0;j<i;++j)
            {
                if(nums[i]> nums[j])
                {
                   if(length[j]>=length[i])
                   {
                       length[i] = length[j]+1;
                       max_length = length[i];
                   }
                }
            }
            
            if(max_length==1)
            {
                count[i]=1;
            }
            
            for(int j=0;j<i;++j)
            {
                if(nums[i]> nums[j])
                {
                   if(length[j]+1 == max_length)
                   {
                       count[i]+=count[j];
                   }
                }
            }
            
            
            
        }
        
        
        int l_max=-1,ans=0;
        for(int l : length)
        {
            l_max = Math.max(l,l_max);
        }
        
        for(int i=0;i<nums.length;++i)
        {
            if(length[i]==l_max)
            {
                ans+=count[i];
            }
        }
        
        return ans;
       
    }

}
