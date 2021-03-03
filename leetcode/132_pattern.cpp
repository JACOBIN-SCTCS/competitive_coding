class Solution {
public:
    
    
    
    bool find132pattern(vector<int>& nums) 
    {
        int num_j = INT_MIN;
        stack<int> s; 
        
        for(int i=nums.size()-1;i>=0;i-=1)
        {
            if(num_j>nums[i])
                return true;
            
            while(!s.empty() && s.top()<nums[i])
            {
                num_j = max(num_j,s.top());
                s.pop();
                
            }
            s.push(nums[i]);
            
            
        }
        
        return false;
        
       
    }
};
