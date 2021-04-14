class Solution {
    public int countServers(int[][] grid) 
    {
         
    
        int[] rowsum = new int[grid.length];
        int[] colsum = new int[grid[0].length];
        
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[i].length;++j)
            {
                if(grid[i][j]==1)
                {
                    rowsum[i]+=1;
                    colsum[j]+=1;
                }
            }
        }
      
        
        int count=0;
        for(int i=0;i<rowsum.length;++i)
        {
           for(int j=0;j<colsum.length;++j)
           {
               if(grid[i][j]==1)
               {
                   if(rowsum[i]>1 || colsum[j]>1)
                       count+=1;
               }
           }
        }
        
        return count;
    }
}
