class Solution {
    
    long[] dp;
    
    public long helper(int[][] questions , int index)
    {
        if(index>=questions.length)
            return 0;
        if(dp[index]!=-1l)
            return dp[index];
        
        long ans = Math.max(helper(questions,index+1),questions[index][0] + helper(questions,
            index+1 + questions[index][1]
        ));
        dp[index] = ans;
        return ans;
    }
    public long mostPoints(int[][] questions) 
    {
        dp = new long[questions.length];
        Arrays.fill(dp,-1l);

        return helper(questions,0);

    }
}
