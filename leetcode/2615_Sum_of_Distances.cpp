// Had to refer editorial to get idea for the formula

class Solution {
public:
    vector<long long> distance(vector<int>& nums) {

        unordered_map<int,vector<long long>> map;
        for(int i=0; i < nums.size(); ++i) {
            map[nums[i]].push_back(i);
        }

        vector<long long> ans(nums.size());
        for(auto& m : map) {
            
            long long total = 0;
            long long prefixTotal = 0;

            auto& arr = m.second;

            for(int i=0; i < arr.size(); ++i)   
                total = total + arr[i];

            int n = arr.size();
            
            for(int i=0; i < n; ++i) {
                ans[arr[i]] = total - prefixTotal*2 +
                    arr[i] * (2*i - n);
                prefixTotal += arr[i];
            }

        }

        return ans;

    }
};
