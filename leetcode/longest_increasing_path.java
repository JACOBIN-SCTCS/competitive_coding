class Solution {
    

    public int DFS(int[][] matrix,int x,int y,int m,int n,int parent,int dp[][])
    {
        
        if( (x<0)||(x>=m)||(y<0)||(y>=n)||matrix[x][y]<=parent)
            return 0;
        
        if(dp[x][y]!=-1)
            return dp[x][y];
        
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        int maximum = 0;
        for(int i=0;i<4;++i)
        {
            int curr = 1+DFS(matrix,x+dx[i],y+dy[i],m,n,matrix[x][y],dp);
            maximum = Math.max(maximum,curr);
        }
        dp[x][y]=maximum;
        return dp[x][y];
                      
    }
    
    
    public int longestIncreasingPath(int[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;++i)
            for(int j=0;j<n;++j)
                dp[i][j]=-1;
        
       int maximum=0;
       for(int i=0;i<m;++i)
       {
           for(int j=0;j<n;++j)
           {
               int curr = DFS(matrix,i,j,m,n,-1,dp);
               maximum =Math.max(curr,maximum); 
           }
       }
       return maximum;
        
    }
}
