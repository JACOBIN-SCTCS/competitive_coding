class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int left=0;
        int right=0;
        int sum =0;
        int ans =0;
        int[] map = new int[10001];
        
        while(right<nums.length)
        {
            sum+=nums[right];
            map[nums[right]]+=1;
            while(map[nums[right]]>1)
            {
                map[nums[left]]-=1;
                sum-=nums[left];
                left++;
            }
            ans = Math.max(ans,sum);
            right+=1;
        }
        return ans;
    }
}
