class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        int m = grid.length; 
        int n = grid[0].length;

        int[] oneRow = new int[m];
        int[] oneCol = new int[n];

        for(int i=0;i<m;++i)
        {
            int sum = 0;
            for(int j=0; j < n ; ++j)
            {
                sum = sum + grid[i][j];
            }
            oneRow[i] =  sum;
        }

        for(int i=0;i<n;++i)
        {
            int sum = 0;
            for(int j=0; j < m ; ++j)
            {
                sum = sum + grid[j][i];
            }
            oneCol[i] =  sum;
        }

        int[][] diff = new int[m][n];
        for(int i=0; i < m ;++i)
        {
            for(int j=0; j< n; ++j)
            {
                diff[i][j] = 2*oneRow[i] + 2*oneCol[j] - m - n;
            }
        }
        return diff;

    }
}
