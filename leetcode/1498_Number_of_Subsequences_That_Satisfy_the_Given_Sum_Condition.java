class Solution {
    
    int mod = 1000000007;

    public int numSubseq(int[] nums, int target) 
    {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length-1;
        int ans = 0 ;
        int[] powers = new int[nums.length];
        powers[0]=1;

        for(int i=1;i<nums.length;++i)
        {
            powers[i] = (powers[i-1]*2)%mod;
        }

        while(left <= right)
        {
            if(nums[left]+nums[right] > target)
            {
                right-=1;
            }
            else
            {
                
                ans  = (ans+powers[right-left])%mod;
                left+=1;
            }
        }

        return ans;
    }
}
