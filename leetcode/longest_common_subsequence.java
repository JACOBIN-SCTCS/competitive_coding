class Solution {
    
    
    int compute(int[][] dp, int t1_idx, int t2_idx, String text1,String text2)
    {
        
        if(t1_idx>=text1.length() || t2_idx>=text2.length())
            return 0;
        
        
        if(dp[t1_idx][t2_idx]!=0)
            return dp[t1_idx][t2_idx];
        
        if(text1.charAt(t1_idx) == text2.charAt(t2_idx))
        {
            dp[t1_idx][t2_idx] = 1+ compute(dp,t1_idx+1,t2_idx+1,text1,text2);
            
        }
        else
        {
            dp[t1_idx][t2_idx] =Math.max(compute(dp,t1_idx+1,t2_idx,text1,text2),
                                compute(dp,t1_idx,t2_idx+1,text1,text2));
        }
        return dp[t1_idx][t2_idx];
    }
    
    
    public int longestCommonSubsequence(String text1, String text2)
    {
        int[][] dp = new int[text1.length()][text2.length()];
        return compute(dp,0,0,text1,text2);
        
    }
}
