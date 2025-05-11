class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        for(int i=0; i < n ; ++i)
        {
            if((arr[i] & 1) == 1)
            {
                if((i-1) >= 0)
                {
                    dp[i] = dp[i-1] + 1;
                    if(dp[i] >=3)
                        return true;
                }
                else
                    dp[i] = 1;
            }
            else
            {
                dp[i] = 0;
            }
        }
        return false;
    }
}
