class Solution {
    
    int[][] dp;
    
    public int dfs(int[][] books, int idx, int current_width,int current_height ,int shelf_width)
    {
        if(idx>=books.length)
            return current_height;
        
        if(dp[idx][current_width]!=-1)
            return dp[idx][current_width];
        
        dp[idx][current_width] = current_height + dfs(books,idx+1,books[idx][0],books[idx][1],shelf_width);
        
        if(current_width+books[idx][0] <= shelf_width)
        {
            dp[idx][current_width]= Math.min(dp[idx][current_width],
                                            
                                            dfs(books,idx+1,current_width+books[idx][0],
                                               
                                               Math.max(current_height,books[idx][1]), shelf_width
                                               )
                                            
                                            );
        }
        return dp[idx][current_width];
        
    }
    
    
    public int minHeightShelves(int[][] books, int shelf_width) 
    {
        dp = new int[books.length][shelf_width+1];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        return dfs(books,0,0,0,shelf_width);
    }
}
