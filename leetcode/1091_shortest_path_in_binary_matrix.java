class Coord
{
    int x;
    int y;
    
    Coord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int[] dx = new int[]{-1,-1,-1,0,1,1,1,0};
        int[] dy = new int[]{-1,0,1,1,1,0,-1,-1};
        int n = grid.length;
        
        int[][] distance = new int[grid.length][grid.length];
        Queue<Coord> q = new LinkedList<Coord>();
        for(int[] row: distance)
        {
            Arrays.fill(row,-1);
        }
        distance[0][0] = 0;
        if(grid[0][0]==1)
            return -1;
        
        q.add(new Coord(0,0));
        while(!q.isEmpty())
        {
            Coord curr = q.remove();
            if(curr.x==(n-1) && curr.y==(n-1))
                return distance[n-1][n-1]+1;
            
            
            for(int i=0;i<8;++i)
            {
                int new_x = curr.x+dx[i];
                int new_y = curr.y+dy[i];
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<n && grid[new_x][new_y]==0
                  && distance[new_x][new_y]==-1 
                  )
                {
                    distance[new_x][new_y] = distance[curr.x][curr.y]+1;
                    q.add(new Coord(new_x,new_y));
                }
            }
        }
        return -1;
        
    }
}
