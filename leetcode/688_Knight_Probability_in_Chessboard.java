class Solution {
    public double knightProbability(int n, int k, int row, int column) 
    {
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1.0;

        int[][] dir = new int[][]{{-1,-2},{-2,-1},{-2,1},{-1,2},
            {1,2}, {2,1} , {2,-1} , {1,-2}
        };

        for(int i=1;i<=k;++i)
        {
            for(int j = 0 ; j< n ; ++j)
            {
                for(int l = 0; l < n ; ++l)
                {
                    for(int m = 0; m< dir.length;++m)
                    {
                        int new_row = j + dir[m][0];
                        int new_col = l + dir[m][1];
                        if(new_row < 0 || new_row >= n || new_col < 0 || new_col >= n)
                            continue;
                        dp[i][j][l] = dp[i][j][l] + (1.0/8)*(dp[i-1][new_row][new_col]);
                    }
                }
            }

        }
        double ans = 0.0;
        for(int i =0 ; i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                ans = (ans) + dp[k][i][j];
            }
        }
        return ans;
    }
}
