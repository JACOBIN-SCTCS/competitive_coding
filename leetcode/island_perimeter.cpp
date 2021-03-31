class Solution 
{
    int ans=0;
    
    void BFS(int[][] grid , boolean[][] visited, int x , int y)
    {
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        visited[x][y] = true;
        for(int i=0;i<4;++i)
        {
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            
            if(new_x<0 || new_x>=grid.length || new_y<0 || new_y >= grid[0].length ||
               grid[new_x][new_y]==0)
            {
                ans+=1;
            }
            else
            {
                if(!visited[new_x][new_y] && grid[new_x][new_y]==1)
                {
                    BFS(grid,visited,new_x,new_y);
                }
            }
        }
        
        
    }
    public int islandPerimeter(int[][] grid) 
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
            {
                if(grid[i][j]==1 && visited[i][j]==false)
                {
                    BFS(grid,visited,i,j);
                }
            }
        }
        return ans;
    }
}
