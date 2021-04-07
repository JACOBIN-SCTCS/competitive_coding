class Solution {
    
    
    public boolean isValid(char[][] board, int r, int c , char digit)
    {
        for(int i=0;i<9;++i)
        {
            if(i!=c && board[r][i]==digit)
                return false;
        }
        
        for(int i=0;i<9;++i)
        {
            if(i!=r && board[i][c]==digit)
                return false;
        }
        
        int startx = (r/3)*3;
        int starty = (c/3)*3;
        
        for(int i=startx;i<startx+3;++i)
            for(int j=starty;j<starty+3;++j)
                if(i==r && j==c)
                    continue;
                else if(board[i][j]==digit)
                    return false;
        
        
        
        return true;
    }
    
    
    public boolean isValidSudoku(char[][] board)
    {
            for(int i=0;i<9;++i)
                for(int j=0;j<9;++j)
                    if(board[i][j]!='.')
                    {
                        boolean ret = isValid(board,i,j,board[i][j]);
                        if(ret==false)
                            return false;
                    }
        
        return true;
    }
}
