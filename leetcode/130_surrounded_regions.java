class Solution {
    
    public void  DFS(char[][] board,int x, int y,boolean[][] visited)
    {
        if(x>=0 && x<visited.length && y>=0 && y<visited[0].length
          && visited[x][y]==false && board[x][y]=='O'
          )
        {
           visited[x][y] = true;
            DFS(board,x+1,y,visited);
             DFS(board,x-1,y,visited);
             DFS(board,x,y+1,visited);
             DFS(board,x,y-1,visited);
            
        }
    }
    
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];   
        
        for(int i=0;i<m;++i)
        {
            if(board[i][0]=='O' && visited[i][0]==false)
            {
              DFS(board,i,0,visited);
            }
            if(board[i][n-1]=='O' && visited[i][n-1]==false)
            {
                DFS(board,i,n-1,visited);
            }
        }
        
        for(int i=0;i<n;++i)
        {
            if(board[0][i]=='O' && visited[0][i]==false)
            {
              DFS(board,0,i,visited);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]==false)
            {
                DFS(board,m-1,i,visited);
            }
        }
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(board[i][j]=='O')
                {
                    if(!visited[i][j])
                        board[i][j]='X';
                }
                    
            }
        }
        
        
        
    }
}
