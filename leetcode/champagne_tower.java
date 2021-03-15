class Solution {
    public double champagneTower(int poured, int query_row, int query_glass)
    {
        double[][] dp = new double[100][100];
        for(int i=0;i<100;++i)
        {
            for(int j=0;j<100;++j)
                dp[i][j]=0.0;

        }
        dp[0][0] = (double)poured;
        
        for(int i=0;i<query_row;++i)
        {
            for(int j=0;j<(i+1);++j)
            {
                double excess=0;
                if(dp[i][j]>1.0)
                {
                    excess = dp[i][j]-1.0;
                }
                
                dp[i+1][j] +=excess/2;
                dp[i+1][j+1] += excess/2;
            }
        }
        
        return (Math.min(dp[query_row][query_glass],1));
            
    }
}
