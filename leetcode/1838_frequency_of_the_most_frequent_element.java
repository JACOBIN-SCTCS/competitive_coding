class Solution {
    public int maxFrequency(int[] nums, int k)
    {
        Arrays.sort(nums);
        int ans = 1;
        int start = 0;
        int right = 0;
        int operations = 0;
        
        while(right<nums.length)
        {
            int prev = ((right-1) >=0)?nums[right-1]:nums[0];
            int excess = nums[right]-prev;
            operations = operations + excess*(right-1-start+1);
            while(operations>k)
            {
                operations -= (nums[right]-nums[start]);
                start+=1;
            }
            ans = Math.max(ans,right-start+1);
            right+=1;
        }
        return ans;
        
    }
}
