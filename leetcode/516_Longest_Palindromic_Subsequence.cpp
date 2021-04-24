class Solution {
public:
    int longestPalindromeSubseq(string s) 
    {
        string t = s;
        reverse(t.begin(),t.end());
        
        vector<vector<int>> dp(t.length()+1,vector<int>(s.length()+1,0));
        
        for(int i=1;i<=t.length();i++)
        {
            for(int j=1;j<=s.length();++j)
            {
                if(t[i-1]==s[j-1])
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[t.length()][s.length()];
        
        
    }
};
