class Coord
{
    int x;
    int y;
    
    Coord(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Solution 
{
    int[][][] dp;
    int rows =0;
    int cols = 0;
    
    public int compute(int[][] grid, Coord r1, Coord r2)
    {
        if(r1.x==rows)
            return 0;
        if(dp[r1.x][r1.y][r2.y]!=-1)
            return dp[r1.x][r1.y][r2.y];
        
        int ans = 0;
        if(r1.y==r2.y)
            ans = grid[r1.x][r1.y];
        else
            ans = grid[r1.x][r1.y] + grid[r2.x][r2.y];
        
        int[] dir = new int[]{-1,0,1};
        
        int next_ans = 0;
        for(int i=0;i<dir.length;++i)
            for(int j=0;j<dir.length;++j)
            {
                if(r1.y+dir[i]<0 || r1.y+dir[i]>=cols || 
                   r2.y+dir[j]<0 || r2.y+dir[j]>=cols
                  )
                    continue;
                Coord new_r1 = new Coord(r1.x+1,r1.y+dir[i]);
                Coord new_r2 = new Coord(r2.x+1,r2.y+ dir[j]);
                next_ans = Math.max(next_ans,compute(grid,new_r1,new_r2));
            }
        dp[r1.x][r1.y][r2.y] = next_ans + ans;
        return next_ans+ans;
       
    }
    public int cherryPickup(int[][] grid)
    {
        rows = grid.length;
        cols = grid[0].length;
        
        dp = new int[rows][cols][cols];
        
        for(int i=0;i<rows;++i)
            for(int j=0;j<cols;++j)
                for(int k=0;k<cols;++k)
                    dp[i][j][k] = -1;
        
         return  compute(grid,new Coord(0,0), new Coord(0,cols-1));
       
        
    }
}
