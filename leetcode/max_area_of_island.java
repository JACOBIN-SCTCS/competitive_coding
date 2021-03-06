class Solution {
    
    
    
    public int BFS(int[][] grid, boolean[][] seen , int x, int y)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length|| seen[x][y] || grid[x][y]==0)
            return 0;
        
        seen[x][y]=true;
        
        
        return (1+ BFS(grid,seen,x-1,y) +  BFS(grid,seen,x,y+1) 
               
                 +  BFS(grid,seen,x+1,y) +  BFS(grid,seen,x,y-1)
               );
        
        
        
    }
    
    
    public int maxAreaOfIsland(int[][] grid)
    {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0 ;
        
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
            {
                ans = Math.max(ans,BFS(grid,seen,i,j));
            }
        }
        
        return ans;
        
    }
}
