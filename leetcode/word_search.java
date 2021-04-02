class Solution 
{
    public boolean checkWord(char[][] board, String word,int x, int y,int idx, int[][] visited)
    {
        
        if(idx==word.length())
            return true;
        if(x<0 || x>=board.length || y<0 || y>= board[0].length || board[x][y]!=word.charAt(idx) || visited[x][y]==1)
            return false;
        
        
        visited[x][y]=1;
        boolean ans = checkWord(board,word,x-1,y,idx+1,visited)
                      || checkWord(board,word,x+1,y,idx+1,visited)
                     ||  checkWord(board,word,x,y-1,idx+1,visited)
                     ||  checkWord(board,word,x,y+1,idx+1,visited);
        
        
        visited[x][y]=0;
        return ans;
        
    }
    
    
    public boolean exist(char[][] board, String word) 
    {
        
        
        int[][] visited = new int[board.length][board[0].length];
        
        for(int i=0;i<board.length;++i)
        {
            for(int j=0;j<board[i].length;++j)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(checkWord(board,word,i,j,0,visited))
                        return true;
                }
            }
        }
        return false;
    }
}
