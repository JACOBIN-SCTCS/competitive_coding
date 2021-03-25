class Solution {
    
    
    public boolean rangecheck(int m,int n, int x, int y)
    {
        if(x<0 || x>=m || y<0 || y>=n)
            return false;
        
        return true;
    }
    
    public void DFS(int[][] matrix,int x, int y , boolean[][] reachable)
    {
        
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        
     
        reachable[x][y] = true;
        for(int i=0;i<4;++i)
        {
             if(rangecheck(matrix.length,matrix[0].length,x+dx[i],y+dy[i]))
             {
                 
                 if(matrix[x+dx[i]][y+dy[i]]>= matrix[x][y] && !reachable[x+dx[i]][y+dy[i]])
                    DFS(matrix,x+dx[i],y+dy[i],reachable);
             }
                 
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) 
    {
         if(matrix.length==0 || matrix[0].length==0 )
             return new ArrayList<>();
        
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        boolean[][] pacificreachable = new boolean[r][c];
        boolean[][] atlanticreachable = new boolean[r][c];
        

        for(int i=0;i<c;++i)
        {
            DFS(matrix,0,i,pacificreachable);
            DFS(matrix,r-1,i,atlanticreachable );
        }
        for(int i=0;i<r;++i)
        {
            DFS(matrix,i,0,pacificreachable);
            DFS(matrix,i,c-1,atlanticreachable);
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
       
        for(int i=0;i<r;++i)
        {
            for(int j=0;j<c;++j)
            {
                if(pacificreachable[i][j] == true && atlanticreachable[i][j]==true)
                {
                    List<Integer> a = new ArrayList<Integer>();
                    a.add(i);
                    a.add(j);
                    result.add(a);
                }
            }
        }
        
        return result;
        
    }
}
