class Solution {
    
    int count=0;
    
    boolean place(int[] col , int r, int c)
    {
        for(int i=0;i<r;++i)
        {
            if(col[i]==c || Math.abs(r-i) == Math.abs(col[i]-c))
                return false;
        }
        
        return true;
    }
    
    void backtrack(int[] col,int r)
    {
        if(r==col.length)
        { 
            count+=1;
            return;
        }
        for(int i=0;i<col.length;++i)
        {
            if(place(col,r,i))
            {
                col[r]=i;
                backtrack(col,r+1);
                
            }
        }
    }
    
    public int totalNQueens(int n) 
    {
        int[] col = new int[n];
        backtrack(col,0);
        return count;
        
    }
}
