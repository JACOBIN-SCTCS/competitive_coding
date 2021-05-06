class Solution {
    
    public void DFS(int[][] grid,int x, int y, boolean[][]  reachable)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length|| reachable[x][y]==true || grid[x][y]==0)
            return;
        
        reachable[x][y] = true;
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        for(int i=0;i<4;++i)
        {
           
            DFS(grid,x+dx[i],y+dy[i],reachable);
        }
    }
    
    public int numEnclaves(int[][] grid) 
    {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] reachable =  new boolean[m][n];
        for(boolean[] row:reachable)
            Arrays.fill(row,false);
        
    
       for(int i=0;i<m;++i)
       {
           DFS(grid,i,0,reachable);
           DFS(grid,i,n-1,reachable);
       }
        
        for(int i=0;i<n;++i)
        {
            DFS(grid,0,i,reachable);
            DFS(grid,m-1,i,reachable);
        }
        
        int count=0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]==1 && reachable[i][j]==false)
                    count+=1;
            }
        }
        return count;
 
    }
}
