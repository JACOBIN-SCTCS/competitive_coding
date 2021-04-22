class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        
        int max_ans = 1;
        int idx=0;
        
        for(int i=0;i<nums.length;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(nums[i]%nums[j]==0)
                {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                   
                }
            }
            
            if(max_ans<=dp[i])
            {
                max_ans = Math.max(max_ans,dp[i]);
                idx=i;
            }
        }
        
        List<Integer> ret_list = new ArrayList<Integer>();
        ret_list.add(nums[idx]);
        max_ans-=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(dp[i]==max_ans && nums[idx]%nums[i]==0)
            {
                max_ans-=1;
                ret_list.add(nums[i]);
                idx=i;
            }
        }
        
        return ret_list;   
    }
}
