class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int right = k;
        int left = k;
        int ans = nums[k];
        int current_min = nums[k];

        while(left > 0 || right < nums.length-1)
        {
            int right_element = (right < nums.length-1) ? nums[right+1] : 0;
            int left_element = (left  > 0) ? nums[left-1] : 0;

            if(left_element < right_element)
            {
                right+=1;
                current_min = Math.min(current_min,nums[right]);
                ans = Math.max(ans,(right-left+1)*current_min);
            }
            else
            {
                left-=1;
                current_min = Math.min(current_min,nums[left]);
                ans = Math.max(ans,(right-left+1)*current_min);
            }

        }
        return ans;
    }
}
