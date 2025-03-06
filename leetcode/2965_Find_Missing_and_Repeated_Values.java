class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Referred editorial for getting the experssion for x+y;
        long sum = 0;
        long squaresum = 0;

        int n = grid.length;
        long tot = n *n;
        for(int i=0; i < grid.length; ++i)
        {
            for(int j=0; j < grid[0].length; ++j)
            {
                sum = sum + grid[i][j];
                squaresum = squaresum + (grid[i][j] * grid[i][j]);
            }
        }

        long sumDiff = sum - (((tot * (tot+1)))/2);
        long squareDiff = squaresum - ((tot*(tot+1)*(2*tot+1))/6);

        int x = (int) (squareDiff / sumDiff + sumDiff)/2;
        int y = (int) (squareDiff / sumDiff - sumDiff)/2;

        return new int[]{x,y};

    }
}
