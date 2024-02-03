class Solution {
    
    int[] dp;

    public int helper(int[] arr , int index, int k)
    {
        if(index >= arr.length)
            return 0;
        
        if(dp[index] != -1)
            return dp[index];
        int max_ans = arr[index];
        int ret = 0 ;

        for(int i = index; i < index + k && i < arr.length ; ++i)
        {
            max_ans = Math.max(max_ans, arr[i]);
            ret = Math.max(ret,  (i-index + 1 )*max_ans + helper(arr,i+1,k));

        }
        dp[index] = ret;
        return ret;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length + 1];
        Arrays.fill(dp,-1);

        int ans = helper(arr,0,k);
        return ans;
    }
}
