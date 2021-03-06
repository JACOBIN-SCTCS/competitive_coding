class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums)
    {
        sort(nums.begin(),nums.end());
        
        vector<vector<int>> ret_list;
        
        
        for(int i=0;i<nums.size();++i)
        {
            int j=i+1;
            int high = nums.size()-1;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            while(j<high)
            {
                int sum = (nums[i]+nums[j]+nums[high]);
                if(sum==0)
                {
                    vector<int> res ;
                    res.push_back(nums[i]);
                    res.push_back(nums[j]);
                    res.push_back(nums[high]);
                    ret_list.push_back(res);
                    
                    j+=1;
                    high-=1;
                    
                    while(j<high&& nums[j]==nums[j-1])
                        j=j+1;
                    while(j<high&& nums[high]==nums[high+1])
                    {
                        high=high-1;
                    }
                    
                }
                else if (sum>0)
                {
                    high=high-1;
                }
                else
                {
                    j=j+1;
                }
                
                
            }
            
        }
        
        return ret_list;
       
    }
};
