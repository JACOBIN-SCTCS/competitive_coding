class Solution {
    public int countPaths(int n, int[][] roads) {

        long MOD = 1000000007;

        long[][][] memo = new long[n][n][2];
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (i != j) 
                {
                  
                    memo[i][j][0] = (long)(1e12);
                    memo[i][j][1] = 0;
                } 
                else 
                {
                    memo[i][j][0] = 0;
                    memo[i][j][1] = 1;
                }
            }
        }

        for (int[] road : roads) 
        {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            memo[startNode][endNode][0] = travelTime;
            memo[endNode][startNode][0] = travelTime;
            memo[startNode][endNode][1] = 1;
            memo[endNode][startNode][1] = 1;
        }

        for(int k=0 ; k < n;++k)
        {
            for(int i=0; i<n; ++i)
            {
                for(int j=0 ; j < n ; ++j)
                {

                    if(i!=k && j!=k)
                    {
                        long newTime = memo[i][k][0] + memo[k][j][0];
                        if(newTime < memo[i][j][0])
                        {
                            memo[i][j][0] = newTime;
                            memo[i][j][1]  =    (memo[i][k][1] * memo[k][j][1]) % MOD;                 
                        }
                        else if(newTime == memo[i][j][0])
                        {
                            memo[i][j][1] = (memo[i][j][1] + (memo[i][k][1] * memo[k][j][1])%MOD)%MOD;
                        }
                    }
                }
            }
        }


        return (int)(memo[n-1][0][1]);

    }
}
