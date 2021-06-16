class Solution 
{
    
    int[][] dp ;
    
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start+=1;
            end-= 1;
        }
        return true;
    }
    
    public int compute(String s , int start, int end)
    {
        if(start>=end)
            return 0;
        
        if(dp[start][end]!=-1)
            return dp[start][end];
        
        if(isPalindrome(s,start,end))
        {
            dp[start][end] = 0;
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = start;i<=end;++i)
        {
            if(isPalindrome(s,start,i))
                ans = Math.min(ans,1 + compute(s,i+1,end));
        }
        dp[start][end] = ans;
        return dp[start][end];
        
    }
    

    public int minCut(String s) 
    {
        dp = new int[s.length()][s.length()];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        return compute(s,0,s.length()-1);
    }
}
