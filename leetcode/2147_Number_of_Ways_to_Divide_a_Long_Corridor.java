class Solution {
    
    int mod = 1000000007;
    int[][] dp;
    

    public int helper(String corridor,int index, int seats)
    {
        if(index == corridor.length())
        {
            if(seats == 2)
                return 1;
            else
                return 0;
        }

        if(dp[index][seats] != -1)
            return dp[index][seats];
        
        int ans = 0;
        if(corridor.charAt(index) == 'S')
        {
            if(seats == 2)
            {
                ans =  helper(corridor,index+1,1);
            }
            else
            {
                ans = helper(corridor,index+1,seats+1);
            }
        }
        else
        {
            if(seats == 2)
            {
                ans = (ans + (helper(corridor,index+1,0) + helper(corridor,index+1,2))%mod) %mod;

            }
            else
            {
                ans = helper(corridor,index+1,seats);
            }
        }
        dp[index][seats] = ans;
        return ans;

    }
    
    public int numberOfWays(String corridor) {
        
        // Had to refer editorial for this question.
        
        dp = new int[corridor.length()][3];
        for(int i=0;i<corridor.length();++i)
            Arrays.fill(dp[i],-1);
        
        return helper(corridor,0,0);

    }
}
