class Solution {
    
    int[][] dp;    
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        dp = new int[n][n];

        for(int i=0; i < n ; ++i)
            dp[n-1][i] = grid[n-1][i];

        for(int i=n-2; i>=0; i--)
        {
            for(int j=0; j < n; ++j)
            {
                int current_ans = Integer.MAX_VALUE;
                for(int k=0; k < n; ++k)
                {
                    if(j!=k)
                    {
                        current_ans = Math.min(current_ans, grid[i][j] + dp[i+1][k]);
                    }
                }
                dp[i][j] = current_ans;

            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i < n; ++i)
            ans = Math.min(ans, dp[0][i]);

        return ans;
    }
}
