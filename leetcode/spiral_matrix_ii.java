class Solution {
    public int[][] generateMatrix(int n) 
    {
        
        
        int[][] matrix = new int[n][n];        
       
        int[] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        int dir = 0;
        
        int x=0,y=0;
        
        for(int i=1;i<=n*n;++i)
        {
            matrix[x][y]=i;

            
            int new_x = x+ dx[dir];
            int new_y = y+ dy[dir];
            
            if((new_x>=0 && new_x<n)&&(new_y>=0 && new_y<n)&& matrix[new_x][new_y]==0 )
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
        return matrix;
        
        
    }
}
