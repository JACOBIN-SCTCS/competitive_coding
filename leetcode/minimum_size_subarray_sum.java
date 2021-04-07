class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        
        int[] sum = new int[nums.length];
        sum[0]= nums[0];
        for(int i=1;i<nums.length;++i)
        {
            sum[i] = sum[i-1]+nums[i];
        }
        
        int ans=Integer.MAX_VALUE;
        
        
        for(int i=0;i<nums.length;++i)
        {
            for(int j=i;j<nums.length;++j)
            {
                int s = sum[j]-sum[i] + nums[i];
                if(s>= target)
                {
                    ans = Math.min(ans, (j-i+1));
                    break;
                }
            }
        }
        
        return  ans==Integer.MAX_VALUE?0:ans;
        
        
    }
}
