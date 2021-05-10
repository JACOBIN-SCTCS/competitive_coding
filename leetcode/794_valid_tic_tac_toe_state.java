class Solution 
{
   public boolean iswin(String[] board, char player)
    {
        for(int i=0;i<3;++i)
        {
            if(board[i].charAt(0)==player && board[i].charAt(1)==player && board[i].charAt(2)==player)
                return true;
        }
        for(int i=0;i<3;++i)
        {
            if(board[0].charAt(i)==player && board[1].charAt(i)==player && board[2].charAt(i)==player)
                return true;
        }
        
        if(board[0].charAt(0)==player && board[1].charAt(1)==player && board[2].charAt(2)==player)
            return true;
        
        if(board[0].charAt(2)==player && board[1].charAt(1)==player && board[2].charAt(0)==player)
            return true;
        
        return false;
    }
    
    
    public boolean validTicTacToe(String[] board) 
    {
        int xcount=0;
        int ocount=0;
        for(String row:board)
        {
            for(int i=0;i<row.length();++i)
            {
                if(row.charAt(i)=='X')
                    xcount+=1;
                if(row.charAt(i)=='O')
                    ocount+=1;
            }
        }
        if(xcount!=ocount && xcount!=(ocount+1))
            return false;
        
        boolean xwin = iswin(board,'X');
        boolean owin = iswin(board,'O');
        if(xwin && owin)
            return false;

        if(xwin || owin)
        {
            if(xwin)
            {
                if(xcount==ocount+1)
                    return true;
                else
                    return false;
            }
            else
            {
                if(xcount==ocount)
                    return true;
                else
                    return false;
            }
        }
    
        return true;
    }
}
