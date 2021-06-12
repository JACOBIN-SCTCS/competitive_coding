class Solution {
    public int minFallingPathSum(int[][] matrix) 
    {
        int n = matrix.length;
        int[][] path_sum = new int[n][n];
        
        for(int i=0;i<n;++i)
            path_sum[0][i] = matrix[0][i];
        for(int i=1;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                int left = (j-1>=0)?path_sum[i-1][j-1]:Integer.MAX_VALUE;
                int right = (j+1<n)?path_sum[i-1][j+1]:Integer.MAX_VALUE;
                int mid = path_sum[i-1][j];
                
                path_sum[i][j] = matrix[i][j] + Math.min(left,Math.min(right,mid));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;++i)
            ans = Math.min(ans,path_sum[n-1][i]);
        return ans;
    }
}
