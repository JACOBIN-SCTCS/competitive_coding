class Solution {
    int[][] dp ;
    
    public int change(int amount, int[] coins) 
    {
        
        
        if(amount==0)
            return 1;
        
        if(coins.length==0)
            return 0;
        
        dp= new int[amount+1][coins.length];
        for(int i=0;i<coins.length;++i)
        {
            dp[0][i] = 1;
        }
        
        for(int i=1;i<=amount;++i)
        {
           for(int j=0;j<coins.length;++j)
           {
                int incl =0,excl=0;
                if((i-coins[j])>=0)
                {
                    incl = dp[i-coins[j]][j];    
                }
                if(j>0)
                {
                    excl = dp[i][j-1];
                }
               dp[i][j] = incl+excl;
           }
        }
        return dp[amount][coins.length-1];
    }
}


// Alternate 
class Solution {
    public int change(int amount, int[] coins) 
    {
        int[] dp = new int[amount+1];
        
        dp[0]=1;
     
        for(int coin:coins)
        {
            for(int i=coin; i<=amount;++i)
            {
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }
}
