class Solution {
    
    public boolean isValid(char[][] board, int x , int y, char ch)
    {
        for(int i=0;i<board[0].length;++i)
        {
            if(board[x][i]==ch)
                return false;
        }
        
        for(int i=0;i<board.length;++i)
        {
            if(board[i][y]==ch)
                return false;
            
        
        }
        
        
        int startx = (x/3)*3;
        int starty = (y/3)*3;
        
        for(int i=startx;i<startx+3;++i)
        {
            for(int j=starty;j<starty+3;++j)
            {
                if(board[i][j]==ch)
                    return false;
            }
        }
        
        
        return true;
    }
    
    
    public boolean solve(char[][] board, int x, int y)
    {
        if(y==board[0].length)
        {
            x+=1;
            y=0;
        }
        if(x==board.length)
            return true;
        
        if(board[x][y]!='.')
            return solve(board,x,y+1);
        
        else
        {
            for(char ch='1';ch<='9';++ch)
            {
                if(isValid(board,x,y,ch))
                {
                    board[x][y]=ch;
                    if(solve(board,x,y+1))
                        return true;
                    else
                        board[x][y]='.';
                }
            }
        }
        
        return false;
    }
    
    
    
    public void solveSudoku(char[][] board)
    {
         solve(board,0,0);   
    }
    
    
}
