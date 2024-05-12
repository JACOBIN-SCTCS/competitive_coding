class Solution {
    public int[][] largestLocal(int[][] grid) 
    {
        int n = grid.length;   
        int[][] ans = new int[n-2][n-2];

        int[] xdir = new int[]{0,-1,-1,-1,0,1,1,1};
        int[] ydir = new int[]{-1,-1,0,1,1,1,0,-1};

        for(int i=0;i<n-2; ++i)
        {
            for(int j=0; j < n-2 ; ++j)
            {
                int max_element = grid[i+1][j+1];
                for(int k=0; k < ydir.length; ++k)
                {
                    int next_element = grid[i+1+xdir[k]][j+1+ydir[k]];
                    max_element = Math.max(max_element,next_element);
                }
                ans[i][j] = max_element;
            }
        }
        return ans;
    }
}
