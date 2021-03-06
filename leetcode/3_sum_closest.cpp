class Solution {
public:
    
    
    
    int threeSumClosest(vector<int>& nums, int target)
    {
        sort(nums.begin(),nums.end());
        int min_abs=INT_MAX;
        int max_sum = INT_MIN;
        
        
        for(int i=0;i<nums.size()&& min_abs!=0;++i)
        {
            int high = nums.size()-1;
            int j=i+1;
            while(j<high)
            {
                int current_sum = nums[i]+nums[j]+nums[high];
                if(abs(current_sum-target)<min_abs)
                {
                    min_abs = abs(current_sum-target);
                    max_sum = current_sum;
                }
                if(current_sum<target)
                    ++j;
                else
                    high--;
            }
      
        }
        
        return max_sum;
        
    }
};
