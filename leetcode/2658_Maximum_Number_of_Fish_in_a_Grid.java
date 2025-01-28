class Solution {
    
    class Pair 
    {
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public int findMaxFish(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int ans = 0;

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        
        for(int i=0; i < m; ++i)
        {
            for(int j=0; j < n ; ++j)
            {
                if(grid[i][j] == 0 || visited[i][j] == 1)
                    continue;
                else
                {
                    Queue<Pair> q = new LinkedList<Pair>();
                    q.add(new Pair(i,j));
                    visited[i][j] = 1;
                    int fishes = 0;
                    while(!q.isEmpty())
                    {
                        Pair popped = q.poll();
                     
                        fishes += grid[popped.x][popped.y];
                        visited[popped.x][popped.y] = 1;
                        for(int k=0; k < dir.length; ++k)
                        {
                            int new_x = popped.x + dir[k][0];
                            int new_y = popped.y + dir[k][1];
                            if(new_x >=0 && new_x < m && new_y >=0 && new_y < n && visited[new_x][new_y]==0 && grid[new_x][new_y] > 0)
                            {
                                q.add(new Pair(new_x,new_y));
                                visited[new_x][new_y] = 1;
                            }
                        }

                    }
                    ans = Math.max(ans,fishes);
                }
            }
        }
        return ans;
    }
}
