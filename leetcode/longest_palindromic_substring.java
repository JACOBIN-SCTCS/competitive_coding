class Solution {
    public String longestPalindrome(String s) 
    {
        boolean[][] dp = new boolean[s.length()][s.length()];
    
        int max_length = Integer.MIN_VALUE;
        int x=0,y=0;
        
        for(int i = s.length()-1;i>=0;i--)
        {
            for(int j=i;j<s.length();++j)
            {
                if(i==j)
                    dp[i][j]=true;
                else if(s.charAt(j)==s.charAt(i))
                {
                    if(Math.abs(j-i)==1)
                        dp[i][j]=true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                        
                }
                else
                {
                    dp[i][j]=false;
                }
                
                if(dp[i][j]&&(max_length<=(j-i)))
                {
                    x=i;
                    y=j;
                    max_length=(j-i);
                }
                
            }
        }
        
        String ret_string = s.substring(x,y+1);
        return ret_string;
        
    }
}
