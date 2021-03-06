class Solution {
public:
    
    
    vector<int> searchRange(vector<int>& nums, int target) 
    {
        vector<int> res;
        if(!binary_search(nums.begin(),nums.end(),target))
        {
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        
        
      
            int idx = lower_bound(nums.begin(),nums.end(),target)-nums.begin();
            res.push_back(idx);
        
       
        
       
            idx = upper_bound(nums.begin(),nums.end(),target)-nums.begin();
            res.push_back(idx-1);        
       
        
        
        return res;
        
    }
};
