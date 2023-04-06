class Solution 
{
    class Coordinate
    {
        int x;
        int y;

        Coordinate(int x , int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public boolean bfs(int[][] grid, int x, int y, int[][] visited)
    {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(x,y));
        boolean isclosed = true;

        int[] xdir = new int[]{-1,0,1,0};
        int[] ydir = new int[]{0,1,0,-1};

        while(!q.isEmpty())
        {
            Coordinate curr = q.poll();
            int current_x = curr.x;
            int current_y = curr.y;
            for(int i=0;i<4;++i)
            {
                int new_x = current_x + xdir[i];
                int new_y = current_y + ydir[i];

                if(new_x <0 || new_x >= grid.length || new_y <0 || new_y >= grid[0].length)
                {
                    isclosed = false;
                    continue;
                }
                if(visited[new_x][new_y]==1 || grid[new_x][new_y]==1)
                    continue;
                visited[new_x][new_y] = 1;
                q.add(new Coordinate(new_x,new_y));
            }

        }
        return isclosed;
    }

    public int closedIsland(int[][] grid) 
    {
        int num_rows = grid.length;
        int num_cols = grid[0].length;
        int[][] visited = new int[num_rows][num_cols];

        int ans = 0;

        for(int i=1; i < visited.length-1;++i)
        {
            for(int j=1;j<visited[0].length-1;++j)
            {
                if(grid[i][j]==0 && visited[i][j]!=1)
                {
                    boolean res =bfs(grid,i,j,visited);
                    if(res)
                        ans+=1; 
                }

            }
        }

        return ans;
    }
}
