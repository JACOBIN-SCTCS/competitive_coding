class Element
{
    int x;
    int y;
    
    Element(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Solution 
{
    public int orangesRotting(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] rottingTime = new int[m][n];
        for(int[] row:rottingTime)
            Arrays.fill(row,Integer.MAX_VALUE);

        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]==2)
                {
                    rottingTime[i][j] = 0;
                    Queue<Element> q = new LinkedList<Element>();
                    q.add(new Element(i,j));
                    while(!q.isEmpty())
                    {
                        Element curr = q.remove();
                        int[] dx = new int[]{-1,0,1,0};
                        int[] dy = new int[]{0,1,0,-1};
                        for(int k=0;k<4;++k)
                        {
                            int new_x = curr.x + dx[k];
                            int new_y = curr.y + dy[k];
                            if(!(new_x>=0 && new_x<m && new_y>=0 && new_y<n))
                                continue;
                            if(grid[new_x][new_y]==0 || grid[new_x][new_y]==2)
                                continue;
                            else
                            {
                                if(1+rottingTime[curr.x][curr.y]<rottingTime[new_x][new_y])
                                {
                                    rottingTime[new_x][new_y] = 1+rottingTime[curr.x][curr.y];
                                    q.add(new Element(new_x,new_y));
                                }
                            }
                        }
                    }
                }
                else if(grid[i][j]==0)
                {
                    rottingTime[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(rottingTime[i][j]==Integer.MAX_VALUE)
                    return -1;
                else
                    ans = Math.max(ans,rottingTime[i][j]);
            }
        }
        return ans;
        
    }
}
