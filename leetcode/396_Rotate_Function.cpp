class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int total = 0;
        int ans = 0;
        int F = 0;
        int n = nums.size();

        for(int i=0; i < n; ++i) {
            total += nums[i];
            F += i*nums[i];
        }

        ans = F;
        for(int i= n-2; i>=0 ; i--) {
            F = F - (n*nums[i+1]) + total;
            ans = max(ans,F);
        }
        return ans;

    }
};
