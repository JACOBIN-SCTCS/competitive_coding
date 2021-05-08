class Solution 
{   
    int compute(String word1, String word2, int i1, int i2, int[][] dp)
    {
        if(i1>=word1.length() || i2>=word2.length())
            return 0;
        if(dp[i1][i2]!=-1)
            return dp[i1][i2];
        
        if(word1.charAt(i1)==word2.charAt(i2))
            dp[i1][i2] = 1+compute(word1,word2,i1+1,i2+1,dp);
        else
            dp[i1][i2] = Math.max(compute(word1,word2,i1+1,i2,dp),compute(word1,word2,i1,i2+1,dp));
        
        return dp[i1][i2];
    }
    
    public int minDistance(String word1, String word2)
    {
	int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        
        int lcs_length= compute(word1,word2,0,0,dp);
        return ( (word1.length()-lcs_length)+(word2.length()-lcs_length));
        
    }
}
