class Solution 
{
    char[] minecount = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    public char[][] updateBoard(char[][] board, int[] click) 
    {
        int clickx = click[0];
        int clicky = click[1];
        if(board[clickx][clicky]=='M')
        {
            board[clickx][clicky]='X';
            return board;
        }
        else if(board[clickx][clicky]=='E')
        {
            
            dfs(board,clickx,clicky);
        }
        return board;
        
    }
    
    public void dfs(char[][] board, int x, int y)
    {
        int[] dx = new int[]{0,-1,-1,-1,0,1,1,1};
        int[] dy = new int[]{-1,-1,0,1,1,1,0,-1};
        int mines=0;
       
        for(int i=0;i<8;++i)
        {
            int newx = x+dx[i];
            int newy = y+dy[i];
            if(newx<0|| newx>=board.length || newy<0 || newy>= board[0].length)
              continue;
            if(board[newx][newy]=='M')
                mines+=1;
        }
        if(mines>0)
        {
            board[x][y] = minecount[mines];
        }
        else
        {
            board[x][y] ='B';
             for(int i=0;i<8;++i)
            {
            
            
                int newx = x+dx[i];
                int newy = y+dy[i];
                if(newx<0|| newx>=board.length || newy<0 || newy>= board[0].length)
                    continue;
                else if(board[newx][newy]=='E')
                {
                    dfs(board,newx,newy);
                }
            }
            
        }

       
      
        
    }
    
    
}
