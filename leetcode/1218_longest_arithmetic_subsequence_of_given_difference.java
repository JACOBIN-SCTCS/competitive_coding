class Solution {
    public int longestSubsequence(int[] arr, int difference)
    {
        int[] dp = new int[20001];
        int bias = 10000;
        
        int ans = 0;
        
        for(int i=0;i<arr.length;++i)
        {
            int prev = arr[i]-difference;
            if(prev>=-10000 && prev<=10000)
            {
                if(dp[bias+prev]>0)
                {
                    dp[arr[i]+bias] = Math.max(dp[arr[i]+bias],1+dp[bias+prev]);
                }
                else
                {
                    dp[arr[i]+bias] = Math.max(1,dp[arr[i]+bias]);
                }
            }
            else
            {
                dp[arr[i]+bias] = Math.max(1,dp[arr[i]+bias]);
            }
        
            ans = Math.max(dp[arr[i]+bias],ans);
        }
        return ans;
    }
}
