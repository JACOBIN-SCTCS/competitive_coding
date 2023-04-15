class Solution 
{
    int[][] dp;

    public int helper(List<List<Integer>> piles,int current_pile, int rem_coins)
    {
        if(rem_coins<=0 || current_pile >= piles.size())
            return 0;

        if(dp[current_pile][rem_coins]!=-1)
            return dp[current_pile][rem_coins];
        
        int ans = 0;
        int not_taking = helper(piles, current_pile+1,rem_coins);
        int taking = 0;
        int prefix_sum = 0 ;
        for(int i=0;i<Math.min(piles.get(current_pile).size(),rem_coins) ; ++i)
        {
            prefix_sum += piles.get(current_pile).get(i);
            taking = Math.max(taking, prefix_sum + helper(piles,current_pile+1,rem_coins- (i+1)));
        }   

        ans = Math.max(not_taking,taking);
        dp[current_pile][rem_coins] = ans;
        return ans;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) 
    {
        dp = new int[piles.size()][k+1];
        for(int i=0;i<piles.size();++i)
            Arrays.fill(dp[i],-1);

        return helper(piles,0,k);

    }
}
