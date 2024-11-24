class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min_abs = Integer.MAX_VALUE;
        int count_neg = 0;

        for(int i=0; i < matrix.length; ++i)
        {
            for(int j=0; j < matrix[0].length; ++j)
            {
                if(matrix[i][j] <= 0)
                {
                    count_neg +=1;
                    
                    sum = sum - matrix[i][j];
                }
                else
                {
                    sum = sum + matrix[i][j];
                }
                min_abs = Math.min(min_abs,Math.abs(matrix[i][j]));
            }
        }
       
        if(count_neg % 2 == 0)
        {
            return sum;
        } 
        else
        {
           
            return (sum - (2*min_abs));
        }
    }
}
