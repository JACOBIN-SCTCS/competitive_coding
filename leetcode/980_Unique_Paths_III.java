class Solution {
    
    int[][] grid;
    int totalcount = 0;


    public int helper(int[][] visited , int x , int y, int count)
    {
        if(this.grid[x][y]==2)
        {   
            if(count==this.totalcount)
                return 1;
            else
                return 0;
        }

        int[] x_dir = {-1,0,1,0};
        int[] y_dir = {0,1,0,-1};

        int c = 0;
        for(int i=0;i<4;++i)
        {
            int new_x = x + x_dir[i];
            int new_y = y + y_dir[i];

            if(new_x>=0 && new_x < visited.length && new_y>=0 && new_y<visited[0].length)
            {
                if(!(this.grid[new_x][new_y] == -1  || visited[new_x][new_y]==1))
                {
                    visited[new_x][new_y] = 1;
                    c += helper(visited,new_x,new_y,count+1);
                    visited[new_x][new_y] = 0;
                }
            }
        }
        return c;
    }

    public int uniquePathsIII(int[][] grid) 
    {
        this.grid = grid;
        int[][] visited = new int[grid.length][grid[0].length];
        int obstacle_cells = 0;
        int m = grid.length;
        int n = grid[0].length;

        int start_x=0,start_y=0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]==-1)
                    obstacle_cells +=1;

                if(grid[i][j]==1)
                {
                        start_x = i;
                        start_y = j;
                }
            }
        }
        this.totalcount = (m*n) - obstacle_cells; 
        visited[start_x][start_y] = 1;
        int ans = helper(visited,start_x,start_y,1);
        return ans;
    }
}
