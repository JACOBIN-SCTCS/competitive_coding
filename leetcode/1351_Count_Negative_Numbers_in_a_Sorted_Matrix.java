class Solution {
    public int countNegatives(int[][] grid) 
    {
        int ans = 0;

        int current_count = 0;
        for(int i = grid[0].length-1;i>=0;i--)
        {
            if(grid[0][i]<0)
            {
                current_count +=1;
            }
            else
            {
                break;
            }
        }
        ans = current_count;
        int current_index = 1;
        while(current_index < grid.length)
        {
            while(current_count < grid[0].length && grid[current_index][(grid[0].length-1)-(current_count)] <0)
            {
                current_count+=1;
            }
            ans = ans + current_count;
            current_index +=1;
        }
        return ans;
        
    }
}
