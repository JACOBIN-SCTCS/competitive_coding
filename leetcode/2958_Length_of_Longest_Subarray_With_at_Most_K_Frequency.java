class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0,  right = 0;
        int ans = 0;

        for(; right < nums.length ; ++right)
        {
             map.put( nums[right], map.getOrDefault(nums[right],0)+1);
             while( left < right && map.get(nums[right]) > k)
             {
                map.put(nums[left],map.get(nums[left])-1);
                left+=1;
             }
             ans = Math.max(ans , (right-left + 1));
        }
        return ans;

    }
}
