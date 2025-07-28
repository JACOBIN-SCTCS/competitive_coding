class Solution {
    
    int[] nums;
    int maximumOR;
    int[][] dp;

    public int helper(int n, int idx, int result)
    {
        if(idx == n)
        {
            if(result == this.maximumOR)
                return 1;
            else
                return 0;
        }

        if(this.dp[idx][result] != 0)
            return this.dp[idx][result];

        int countIncluded = helper(n, idx+1, result| this.nums[idx]);
        int countExcluded = helper(n, idx+1, result);
        this.dp[idx][result] = countIncluded + countExcluded;

        return this.dp[idx][result];
    }
    
    public int countMaxOrSubsets(int[] nums) {
        // Referred editorial for DP solution;
        int n = nums.length;
        this.maximumOR = 0;
        this.nums = nums;


        for(int num : nums)
            this.maximumOR |= num;

        this.dp = new int[n][this.maximumOR+1];

        int res = helper(n, 0, 0);
        return res;
    
    }
}
