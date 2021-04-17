class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) 
    {
        if(nums.size()<=2)
        {
            return 0;
        }
        
        vector<int> dp(nums.size(),0);    
        int ans =0;
        for(int i=2;i<nums.size();++i)
        {
            if((nums[i-1]-nums[i-2]) ==(nums[i]-nums[i-1]))
            {
                dp[i] = 1 + dp[i-1];
                ans+=dp[i];
            }
            
        }
        return ans;
    
    }
    
};
