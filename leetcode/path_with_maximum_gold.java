class Solution
{
    
    int path_sum=0;
    
    public int compute(int[][] grid, int x, int y, int[][] visited)
    {
       if(x<0 || x>= grid.length || y<0 || y>= grid[0].length || visited[x][y]==1
         || grid[x][y]==0
         ) 
           return 0;
        
        visited[x][y]=1;
        
        int left = compute(grid,x,y+1,visited);
        int right = compute(grid,x,y-1,visited);
        int top = compute(grid,x-1,y,visited);
        int bottom  = compute(grid,x+1,y,visited);
        
        int maximum = Math.max(left,Math.max(right,Math.max(top,bottom)));
        visited[x][y]=0;
        return grid[x][y]+maximum;
        
    }
    
    public int getMaximumGold(int[][] grid) 
    {
        int[][] visited = new int[grid.length][grid[0].length];
        path_sum = Integer.MIN_VALUE;
        
        for(int i=0;i<grid.length;++i)
            for(int j=0;j<grid[0].length;++j)
            {
                if(grid[i][j]>0)
                    path_sum = Math.max(path_sum,compute(grid,i,j,visited));
            }
        
        return path_sum;
    }
}
