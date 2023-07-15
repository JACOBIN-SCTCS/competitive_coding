class Solution 
{
    int[][] dp;

    public int helper(int index,int k, int[][] events)
    {
        if(k == 0 || index == events.length)
            return 0;
    
        if(dp[k][index] != -1)
            return dp[k][index];
        
        int ans  = 0;

        int new_index = upperbound(events, events[index][1]);
        ans = events[index][2] + helper(new_index,k-1,events);
        ans = Math.max(ans,helper(index+1,k,events));
        dp[k][index] = ans;
        return ans;

    }

    public int upperbound(int[][] events, int target)
    {
        int left = 0;
        int right = events.length;
        while(left < right)
        {
            int mid = (left+right)/2;
            if(events[mid][0] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int maxValue(int[][] events, int k) 
    {
        Arrays.sort(events,new Comparator<int[]>(){
            public int compare(int[] a , int[] b)
            {
                return (a[0]-b[0]);
            }
        });   

        dp = new int[k+1][events.length];
        for(int i=0;i<=k;++i)
            Arrays.fill(dp[i],-1);     
        return helper(0,k,events);
    }
}
