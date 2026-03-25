class Solution {
    public boolean canPartitionGrid(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        long[] horizontal = new long[m];   
        long sum = 0;
        long[] vertical =   new long[n];
        long runningsum = 0;
        

        for(int i=0; i < m; i++) 
        {
            for(int j=0; j < n; j++)
            {
                horizontal[i] += grid[i][j];
                vertical[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        if(sum % 2 != 0)
            return false;

        long halfsum = sum / 2;

        runningsum = 0;        
        for(int i=0; i < m; ++i) {
            runningsum = runningsum + horizontal[i];
        
            if(runningsum == halfsum) {
                return true;
            }
            
            if(runningsum > halfsum) 
                break;
        }

        runningsum = 0;        
        for(int i=0; i < n; ++i) {
            runningsum = runningsum + vertical[i];
        
            if(runningsum == halfsum) {
                return true;
            }
            
            if(runningsum > halfsum) 
                break;
        }

        return false;
    }
}3546. Equal Sum Grid Partition I
