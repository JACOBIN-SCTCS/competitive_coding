class Solution {
    
    
    int[][][] dp;
    
    public int compute(String[] strs, int zeros, int ones, int index)
    {
        if(index>=strs.length)
            return 0;
        
        if(dp[index][zeros][ones]!=0)
            return dp[index][zeros][ones];
        
        int zero_count=0;
        int one_count=0;
        
        for(int i=0;i<strs[index].length();++i)
        {
            if(strs[index].charAt(i)=='0')
                zero_count+=1;
            else
                one_count+=1;
        }
        
        if(zero_count<=zeros && one_count<= ones)
        {
            dp[index][zeros][ones] = Math.max(compute(strs,zeros,ones,index+1), 1+compute(strs,zeros-zero_count,
                                                                                        ones-one_count,
                                                                                        index+1
                                                                                       
                                                                                       ));
            
        }
        else
        {
            dp[index][zeros][ones] = compute(strs,zeros,ones,index+1);
        }
        
        return dp[index][zeros][ones];
    }
    
    
    public int findMaxForm(String[] strs, int m, int n) 
    {
     
        dp = new int[strs.length][m+1][n+1];
        return compute(strs,m,n,0);
        
        
    }
}
