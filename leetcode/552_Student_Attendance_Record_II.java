class Solution {
    
    
    
    public int checkRecord(int n) {

        int mod = 1000000007;
        int[][][] dp = new int[n+1][2][3];

        dp[0][0][0] = 1;
        
        
        for(int i=0 ; i < n ; ++i)
        {
            for(int absent =0 ; absent < 2 ; ++absent)
            {
                for(int leave = 0; leave <= 2; ++leave)
                {
                    dp[i+1][absent][0] = (dp[i+1][absent][0] + dp[i][absent][leave]) % mod;
                    if(absent < 1)
                    {
                        dp[i+1][absent+1][0] = (dp[i+1][absent+1][0] + dp[i][absent][leave]) % mod;
                    }
                    if(leave < 2)
                    {
                        dp[i+1][absent][leave+1] = (dp[i+1][absent][leave+1] + dp[i][absent][leave]) % mod;
                    }

                }
            }
        }

        int count = 0;
        for(int absent =0 ; absent < 2 ; ++absent)
        {
            for(int leave = 0; leave <= 2; ++leave)
            {
                count = (count + dp[n][absent][leave]) % mod;
            }
        }
        return count;

    }
}
