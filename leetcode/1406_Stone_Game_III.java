class Solution {
   
    int[] dp;


    public int helper(int[] stones , int idx)
    {
        // The running result (return value from function )represents the gains that Alice will have
        // While Alice tries to maximize the sum Bob tries to minimize it 
        // If running sum becomes less than 0 it means bob got high score
        // else Alice and a zero if there is a tie.

        // We need to alternate between addition and substraction


        if(idx>=stones.length)
            return 0;
        if(dp[idx] != Integer.MAX_VALUE)
            return dp[idx];
        
        int ans = stones[idx] - helper(stones,idx+1);
        int sum = stones[idx];

        for(int i =idx+1 ; i < Math.min(stones.length,idx+3);++i)
        {
            sum = sum + stones[i];
            ans = Math.max(ans,sum - helper(stones,i+1));
        }
        dp[idx] = ans;
        return ans;

    }
   
   
    public String stoneGameIII(int[] stoneValue) 
    {
       
        dp = new int[stoneValue.length];
        Arrays.fill(dp,Integer.MAX_VALUE);

        int ret = helper(stoneValue,0);
        if(ret > 0)
            return "Alice";
        else if(ret==0)
            return "Tie";
        else
            return "Bob";
        
        
    }
}
