class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) 
    {
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                if(i-1>=0 && j-1>=0 )
                {
                    if(matrix[i][j]!=matrix[i-1][j-1])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
            
    }
}
