class Solution {
    
    int[] ans;
    
    
    public void dfs(int[][] grid,int row, int col, int startcol)
    {
        if(row==grid.length)
        {
            ans[startcol] = col;
            return;
        }
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
        {
            ans[startcol] = -1;
            return ;
        }
        
        if(grid[row][col] == 1)
        {
            if(col+1<grid[0].length && grid[row][col+1]==grid[row][col])
            {
                dfs(grid,row+1,col+1,startcol);
            
            }
            else
            {
                ans[startcol] = -1;
                return ;
            }
        }
        else
        {
            if(col-1>=0 && grid[row][col-1] == grid[row][col])
            {
                dfs(grid,row+1,col-1,startcol);
            }
            else
            {
                ans[startcol] = -1;
                return;
            }
        }
            
    }
    
    public int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        ans = new int[n];
        Arrays.fill(ans,-1);
        
        for(int i=0;i<n;++i)
            dfs(grid,0,i,i);
        
        return ans;
    }
}
