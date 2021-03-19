class Solution {
    
    List<List<String>> retlist = new ArrayList<List<String>>();
    
    boolean place(int[] row , int r,int c)
    {
        for(int i=0;i<r;++i)
        {
            if(row[i]==c || Math.abs(row[i]-c)==Math.abs(r-i))
                return false;
        }
        return true;
    }
    
    void backtrack(int[] row , int r)
    {
        if(r==row.length)
        {
            List<String> conf = new ArrayList<String>();
            char[] _char = new char[row.length];
            Arrays.fill(_char,'.');
           
            
            for(int i=0;i<r;++i)
            {
                _char[row[i]] = 'Q';
                conf.add(new String(_char));
                _char[row[i]]='.';
            }
            
            retlist.add(conf);
            return;
        }
        
        for(int i=0;i<row.length;++i)
        {
            if(place(row,r,i))
            {
                row[r]=i;
                backtrack(row,r+1);
            }
        }
        
        
        
    }
    
    public List<List<String>> solveNQueens(int n) 
    {
        int[] row = new int[n];    
        
        backtrack(row,0);
        return retlist;
        
    }
}
