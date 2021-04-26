class Solution {
    public void rotate(int[][] matrix) 
    {
        
        for(int i =0;i<matrix.length;++i)
        {
            for(int j=i;j<matrix[0].length;++j)
            {
                int tmp  =matrix[i][j];
                matrix[i][j] =  matrix[j][i];
                matrix[j][i] = tmp;
            }
            
        }
        
        for(int i =0;i<(matrix[0].length/2);++i)
        {
            for(int j=0;j<matrix.length;++j)
            {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix[0].length-1-i];
                 matrix[j][matrix[0].length-1-i] = tmp;
            }
        }

    }
}
