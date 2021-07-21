class Solution 
{
    int[][] dp;
    public int compute(int[] piles, int left, int right)
    {
        if(left>=right)
            return 0;
        
        if(dp[left][right]!=-1)
            return dp[left][right];
        
        int currentplayer = ((right-left+1)%2==0)?1:2;
        if(currentplayer==1)
        {
            dp[left][right] = Math.max(piles[left] + compute(piles,left+1,right),
                                      piles[right] + compute(piles,left,right-1)
                                      );
        
            return dp[left][right];
        }
        else
        {
            dp[left][right] = Math.max((-piles[left]) + compute(piles,left+1,right),
                                      (-piles[right]) + compute(piles,left,right-1));
            return dp[left][right];
        }
        
    }
    
    public boolean stoneGame(int[] piles) 
    {
        dp = new int[piles.length][piles.length];
        for(int [] row:dp)
            Arrays.fill(row,-1);
        
        int result = compute(piles,0,piles.length-1);
        return (result>=0)?true:false;
    }
}
