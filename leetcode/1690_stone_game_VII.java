class Solution {
    
    int[][] dp;
    
    public int compute(int[] stones,int i, int j, int sum)
    {
        if(i>=j)
            return 0;
        if(Math.abs(j-i)==1)
            return Math.max(stones[i],stones[j]);
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        dp[i][j] = Math.max(
                              sum-stones[i] - compute(stones,i+1,j,sum-stones[i]),
                              sum- stones[j] - compute(stones,i,j-1,sum-stones[j])
                           
                           );
        return dp[i][j];
    }
    
    public int stoneGameVII(int[] stones) 
    {
        dp = new int[stones.length][stones.length];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        int sum = 0;
        for(int stone:stones)
            sum += stone;
        
        return compute(stones,0,stones.length-1,sum);
    }
}
