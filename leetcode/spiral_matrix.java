class Solution {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> retlist = new ArrayList<Integer>();
        
        
        boolean[][]  visited   = new boolean[r][c];
        int[] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        int dir = 0;
        
        int x=0,y=0;
        
        for(int i=0;i<r*c;++i)
        {
            retlist.add(matrix[x][y]);
            visited[x][y] = true;
            
            int new_x = x+ dx[dir];
            int new_y = y+ dy[dir];
            
            if((new_x>=0 && new_x<r)&&(new_y>=0 && new_y<c)&& !visited[new_x][new_y] )
            {
                x =new_x;
                y = new_y;
            }
            else
            {
                dir = (dir+1)%4;
                x += dx[dir];
                y += dy[dir];
            }
          
        }
        return retlist;
        
        
        
    }
}
