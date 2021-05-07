class Solution {
    
    
    public int compute(HashSet<Integer> set, int[] costs, int day, int[] dp)
    {
        if(day>=366)
            return 0;
        
        if(dp[day]!=-1)
            return dp[day];
        
        int ans=0;
        if(set.contains(day))
        {
            ans = Math.min(costs[0]+compute(set,costs,day+1,dp),costs[1]+compute(set,costs,day+7,dp));
            ans = Math.min(ans,costs[2]+compute(set,costs,day+30,dp));
        }
        else
        {
           ans = compute(set,costs,day+1,dp);
        }
        dp[day]=ans;
        return dp[day];
    }
    
    
    public int mincostTickets(int[] days, int[] costs) 
    {
        int[] dp = new int[366];
        Arrays.fill(dp,-1);
    
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int day:days)
            set.add(day);
        
        return compute(set,costs,1,dp);
        
     
    }
}
