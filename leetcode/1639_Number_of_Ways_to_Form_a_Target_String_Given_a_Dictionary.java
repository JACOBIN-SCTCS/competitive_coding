class Solution {
   
    long[][] dp ; 
    long mod =  1000000007;
    
    public long helper(String target, int i, int j, int[][] freq)
    {
        if(i==target.length())
            return 1;
        if(j==freq.length)
        {
            if(i==target.length())
                return 1;
            else
                return 0;
        }
        if(dp[i][j]!=-1l)
            return dp[i][j];
        
        long ans = 0;
        ans = (ans + freq[j][target.charAt(i)-'a']*helper(target,i+1,j+1,freq))%mod;
        ans = (ans + helper(target,i,j+1,freq))%mod;
        dp[i][j] = ans;
        return ans;

    }

    public int numWays(String[] words, String target) 
    {
        int[][] freq = new int[words[0].length()][26];
        dp = new long[target.length()][words[0].length()];

        for(int i=0;i<target.length();++i)
            Arrays.fill(dp[i],-1l);
        
        for(int i = 0 ; i < words[0].length();++i)
        {
            for(int j=0;j<words.length;++j)
            {
                freq[i][words[j].charAt(i)-'a'] +=1;
            }
        }

        return (int) helper(target,0,0,freq);
    }
}
