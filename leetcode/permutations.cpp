class Solution {
public:
   
    vector<vector<int>> retlist;
    int chosen[7];
    
    void generatePermutation(vector<int>& nums, vector<int> ans)
    {
            if(ans.size()==nums.size())
            {
                
                vector<int> pushed = ans;
                retlist.push_back(pushed);
            }
        
            for(int i=0;i<nums.size();++i)
            {
                if(chosen[i]==0)
                {
                    chosen[i]=1;
                    ans.push_back(nums[i]);
                    generatePermutation(nums,ans);
                    ans.pop_back();
                    chosen[i]=0;
                }
            }
    }
    
    vector<vector<int>> permute(vector<int>& nums) 
    {
        vector<int> res;
        generatePermutation(nums,res);
        return retlist;
    }
};
