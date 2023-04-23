class Solution {
    
    int mod =1000000007 ;
    long[] dp;

    public long helper(String s,int index, int k)
    {
        if(index==s.length())
            return 1;
        
        if(dp[index]!=-1)
            return dp[index];

        
        if(s.charAt(index)=='0')
            return 0;
        
        long count = 0;
        long number = 0;

        for(int i=index;i<s.length();++i)
        {
            number = number*10 + (long)(s.charAt(i)-'0');
            if(number > k)
                break;
            else
                count = (count + helper(s,i+1,k))%mod;
        }
        dp[index] = count%mod;
        return dp[index];
    }

    public int numberOfArrays(String s, int k) 
    {
        dp = new long[s.length()];
        Arrays.fill(dp,-1l);
        return (int)helper(s,0,k);
    }
}
