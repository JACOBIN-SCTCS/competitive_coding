class Solution {
    public int numSpecial(int[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i=0;i<m;++i)
        {
            int sum = 0;
            for(int j=0;j<n;++j)
            {

                sum = sum + mat[i][j];
            }
            row[i] = sum;
        }

        for(int i=0;i<n;++i)
        {
            int sum = 0;
            for(int j=0;j<m;++j)
            {
                sum = sum + mat[j][i];
            }
            col[i] = sum;
        }

      
        int ans = 0;
        for(int i =0 ; i < m ; ++i)
        {
            for(int j=0; j < n ; ++j)
            {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1)
                {
                    ans +=1;
                }
            }
        }
        return ans;

        
    }
}
