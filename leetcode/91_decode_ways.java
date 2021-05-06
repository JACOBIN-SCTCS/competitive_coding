class Solution {
    
    public int compute(String s , int idx, int[] dp)
    {
        if(idx==s.length())
        {
            return 1;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        
        if(s.charAt(idx)=='0')
        {
            dp[idx]=0;
            return 0;
        }
        int ans=0;
        ans += compute(s,idx+1,dp);
        if(s.charAt(idx)=='1')
        {
            if(idx+1<s.length())
            {
                ans+=compute(s,idx+2,dp);
            }
        }
        if(s.charAt(idx)=='2')
        {
            if(idx+1<s.length() && s.charAt(idx+1)>='0' && s.charAt(idx+1)<='6')
            {
                ans+=compute(s,idx+2,dp);
            }
        }
        dp[idx]=ans;
        return dp[idx];
            
    }
        
    public int numDecodings(String s) 
    {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return compute(s,0,dp);
        
    }
}
