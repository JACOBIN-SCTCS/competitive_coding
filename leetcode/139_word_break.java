class Solution {
    
    int[][] dp ;
    HashSet<String> dict ;
    
    
    public int compute(String s, int start, int end)
    {
        if(start>end)
            return 0;
        if(dp[start][end]!=-1)
            return dp[start][end];
        
        if(dict.contains(s.substring(start,end+1)))
            return 1;
        for(int k = start;k<end;++k)
        {
            if(dict.contains(s.substring(start,k+1)))
            {
                int rem_ans = compute(s,k+1,end);
                if(rem_ans==1)
                {
                    dp[start][end] =1 ;
                    return 1;
                }
            }
        }
        dp[start][end] = 0;
        return 0;
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        dict = new HashSet<String>();
        for(String word:wordDict)
            dict.add(word);
        
        dp = new int[s.length()][s.length()];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        
        int ans = compute(s,0,s.length()-1);
        return ((ans==1)?true:false);
    }
}
