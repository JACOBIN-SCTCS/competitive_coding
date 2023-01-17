class Solution {
    
    int[][] dp;
    
    public int flips(String s,int idx , int one_seen)
    {
        if(idx==s.length())
            return 0;
        if(dp[one_seen][idx] != -1)
        {
            return dp[one_seen][idx];
        }
        int res = 0;
        if(one_seen ==  1)
        {
            if(s.charAt(idx)=='0')
            {
                res = 1 + flips(s,idx+1,1);
            }
            else
            {
                res = flips(s,idx+1,1);
            }
        }
        else
        {
            if(s.charAt(idx)=='1')
            {
                int res1 = 1 + flips(s,idx+1,0);
                int res2 = flips(s,idx+1,1);
                res = Math.min(res1,res2);
            }
            else
            {
                int res1 = 1 + flips(s,idx+1,1);
                int res2 = flips(s,idx+1,0);
                res = Math.min(res1,res2);
            }
        }
        dp[one_seen][idx] = res;
        return res;
    }

    public int minFlipsMonoIncr(String s) 
    {
        dp = new int[2][s.length()];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);

        int ans = flips(s,0,0);
        return ans;


    }
}
