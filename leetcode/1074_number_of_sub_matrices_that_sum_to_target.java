class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) 
    {
       
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] sum = new int[m][n];
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(i==0&&j==0)
                    sum[i][j]=matrix[0][0];
                else if(i==0)
                {
                    sum[i][j] = sum[i][j-1]+matrix[i][j];
                }
                else if(j==0)
                    sum[i][j] = sum[i-1][j]+ matrix[i][j];
                else
                {
                    sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1]-sum[i-1][j-1];
                }       
            }
        }
        int count=0;
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                for(int k=i;k<m;++k)
                {
                    for(int l=j;l<n;++l)
                    {
                        int current = sum[k][l];
                        if(i>0)
                            current-= sum[i-1][l];
                        if(j>0)
                            current -= sum[k][j-1];
                        if(i>0 && j>0)
                            current += sum[i-1][j-1];
                        
                        if(current==target)
                            count+=1;
                    }
                }
            }
        }
       
        return count;
        
        
    }
}
