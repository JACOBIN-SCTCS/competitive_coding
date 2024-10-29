class Solution {
    public int maxMoves(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        int[][] max_moves = new int[m][n];
       

        for(int j = n-2; j>=0 ; j--)
        {
            for(int i=0; i < m; ++i)
            {
                int current_ans = 0;
                int current_value = grid[i][j];
                
                if((i-1) >= 0 && grid[i-1][j+1] >current_value)
                {
                    current_ans = Math.max(current_ans, 1+ max_moves[i-1][j+1]);
                }
                if(i+1 < m && grid[i+1][j+1] > current_value)
                {
                    current_ans = Math.max(current_ans , 1+ max_moves[i+1][j+1]);
                }
                if(grid[i][j+1] > current_value)
                    current_ans = Math.max(current_ans , 1+ max_moves[i][j+1]);

                max_moves[i][j] = current_ans;
               

            }
        }
        for(int i=0; i < m ; ++i)
            ans = Math.max(ans, max_moves[i][0]);
        
        return ans;
    }
}
