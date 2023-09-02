class Solution 
{
    HashSet<String> dict_set;
    int[] dp;
 
    public int helper(int start, String s)
    {
        if(start>= s.length())
            return 0;
        
        if(dp[start] != -1)
            return dp[start];
        
        int ans = 1 + helper(start+1,s);

        for(int end = start; end < s.length();++end)
        {
            String substring = s.substring(start,end+1);
            if(dict_set.contains(substring))
            {
                ans = Math.min(ans,helper(end+1,s));
            }
        }
        dp[start] = ans;
        return ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        dict_set = new HashSet<String>();
        for(String word : dictionary)
        {
            dict_set.add(word);
        }    
        dp = new int[s.length()];
        Arrays.fill(dp,-1);

        int ans = helper(0,s);
        return ans;
    }
}
