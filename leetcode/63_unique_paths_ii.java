class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int[][] num_ways = new int[obstacleGrid.length][obstacleGrid[0].length];
        num_ways[0][0] = (obstacleGrid[0][0]==1)?0:1;
       
        for(int i=0;i<obstacleGrid.length;++i)
        {
            for(int j=0;j<obstacleGrid[0].length;++j)
            {
                if(i==0 && j==0)
                    continue;
                else if(i==0)
                {
                    if(obstacleGrid[i][j]==1)
                        num_ways[i][j] = 0;
                    else
                        num_ways[i][j] = num_ways[i][j-1];
                }
                else if(j==0)
                {
                    if(obstacleGrid[i][j]==1)
                        num_ways[i][j] = 0;
                    else
                        num_ways[i][j] = num_ways[i-1][j];
                }
                else
                {
                    if(obstacleGrid[i][j]==1)
                        num_ways[i][j] = 0;
                    else
                        num_ways[i][j] = num_ways[i][j-1] + num_ways[i-1][j];
                }
            }
        }
        return num_ways[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
