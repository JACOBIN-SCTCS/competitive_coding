class Solution {
    public int matrixScore(int[][] grid) {
        
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i < m; ++i)
        {
            if(grid[i][0] == 0)
            {
                for(int j=0; j < n; ++j)
                {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        ans = ans + m*((1<<(n-1)));

        for(int j=1; j < n ; ++j)
        {
            int ones_count = 0;
            for(int i=0;i< m; ++i)
            {
                if(grid[i][j] == 1)
                    ones_count+=1;
            }
            if(m-ones_count > ones_count)
                ans = ans + (m-ones_count)*((1<<(n-1-j)));
            else
                ans = ans + ones_count*((1<<(n-1-j)));
        }
        return ans;
    }
}
