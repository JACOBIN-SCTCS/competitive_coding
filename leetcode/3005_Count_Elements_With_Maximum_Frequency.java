class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max_freq = 0;

        for(int i=0; i < nums.length; ++i)
        {
            count[nums[i]] += 1;
            max_freq = Math.max(max_freq, count[nums[i]]);
        }
        int ans = 0;
        for(int i=0; i < 101; ++i)
        {
            if(count[i] == max_freq)
                ans += max_freq;
        }
        return ans;
    }
}
