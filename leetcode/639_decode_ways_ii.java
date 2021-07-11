class Solution {
    
    long[] dp ;
    long mod = 1000000007;
    
    public long compute(String s, int index)
    {
        if(index>=s.length())
            return 1l;
        
        if(dp[index]!=-1l)
        {
            return dp[index];
        }
        
        if(s.charAt(index)=='0')
        {
            dp[index] = 0l;
            return 0l;
        }
        
        long num_ways = 0l;
         
        if(s.charAt(index)=='*')
        {
            num_ways = (num_ways + (9*compute(s,index+1))%mod)%mod;
            if(index+1<s.length())
            {
                if(s.charAt(index+1)=='*')
                {
                    num_ways = (num_ways+(15*(compute(s,index+2)))%mod)%mod;
                    dp[index] = num_ways%mod;
                    return dp[index];
                }
                
                if(s.charAt(index+1)<='6' && s.charAt(index+1)>='0')
                {
                    num_ways = (num_ways+((compute(s,index+2)))%mod)%mod;
                    
                }
                
                num_ways = (num_ways+((compute(s,index+2)))%mod)%mod;
                
            }
            dp[index] = num_ways%mod;
            return dp[index];
        }
        
        
        else if(s.charAt(index)=='1')
        {
            num_ways = (num_ways+((compute(s,index+1)))%mod)%mod;
            if(index+1<s.length())
            {
                if(s.charAt(index+1)=='*')
                    num_ways = (num_ways+(9*(compute(s,index+2)))%mod)%mod;
                else
                    num_ways = (num_ways+((compute(s,index+2)))%mod)%mod;
            }
            dp[index] = num_ways%mod;
            return dp[index];
        }
        
        else if(s.charAt(index)=='2')
        {
            num_ways = (num_ways+((compute(s,index+1)))%mod)%mod;
            if(index+1<s.length())
            {
                if(s.charAt(index+1)=='*')
                    num_ways = (num_ways+(6*(compute(s,index+2)))%mod)%mod;
                else if(s.charAt(index+1)>='0' && s.charAt(index+1)<='6')
                    num_ways = (num_ways+((compute(s,index+2)))%mod)%mod;
            }
            dp[index] = num_ways%mod;
            return dp[index];
        }
        else
        {
            num_ways = (num_ways+((compute(s,index+1)))%mod)%mod;
            dp[index] = num_ways;
            return dp[index];
        }
        
    }
    
    public int numDecodings(String s) {
      
        dp = new long[s.length()];
        Arrays.fill(dp,-1l);
        
        return (int)compute(s,0);
    }
}
