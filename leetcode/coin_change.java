class Solution {
    public int coinChange(int[] coins, int amount)
    {
    
        
        int[] dp = new int[amount+1];
        for(int i=0;i<amount+1;++i)
            dp[i]=amount+1;
       
        dp[0]=0;
        for(int i=1; i<=amount; ++i)
        {
            for(int coin:coins)
            {
                if(coin<=i)
                {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        
        if(dp[amount]>amount)
            return -1;
        
        return dp[amount];
        
        
    }
}
