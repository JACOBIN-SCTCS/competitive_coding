class Solution 
{
    long[][] dp;
    long mod = 1000000007;

    long helper(int[][] grid, int i, int j)
    {
        if(dp[i][j]!=-1l) 
            return dp[i][j];   
        
        long ans = 1;
        int[] xdir = new int[]{-1,0,1,0};
        int[] ydir = new int[]{0,1,0,-1};

        for(int k=0;k<4;++k)
        {
            int new_x = i + xdir[k];
            int new_y = j + ydir[k];

            if(new_x <0 || new_x >= grid.length || new_y <0 || new_y >= grid[0].length)
                continue;
            if(grid[new_x][new_y] > grid[i][j])
            {
               ans = (ans + helper(grid,new_x,new_y))%mod;
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public int countPaths(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        dp = new long[m][n];
        for(int i=0;i<m;++i)
            Arrays.fill(dp[i],-1l);
        
        long ans = 0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                ans = (ans + helper(grid,i,j))%mod;
            }
        }

        return (int) ans;
    }

}
