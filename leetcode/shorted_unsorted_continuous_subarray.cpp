class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums)
    {
      
        int s=0;
        int e=nums.size()-1;
        
        int i;
        
        
        
        for(i=0;i<nums.size()-1;++i)
        {
            if(nums[i]>nums[i+1])
            {
                s=i;
                break;
            }
        }
        
        
        if(i==nums.size()-1)
            return 0;
        
        for(i=nums.size()-1;i>0;i--)
        {
            if(nums[i]<nums[i-1])
            {
                e=i;
                break;
            }
        }
        
        
        int min=nums[s];
        int max = nums[s];
        
        for(i=s+1;i<=e;++i)
        {
            if(nums[i]>max)
                max=nums[i];
            if(nums[i]<min)
                min=nums[i];
        }
        
        for(i=0;i<s;++i)
        {
            if(nums[i]>min)
            {
                s=i;
                break;
            }
        }
        
        for(i=nums.size()-1;i>=e+1;i--)
        {
            if(nums[i]<max)
            {
                e=i;
                break;
            }
        }
        
        return e-s+1;
    }
};
