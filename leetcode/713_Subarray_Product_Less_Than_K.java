class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int ans = 0;
        int left = 0;
        int right = 0;

        int product = 1;

        for(; right < nums.length; right ++ )
        {
            product = product * nums[right];
            while(left < right && product >= k)
            {
                product = product / nums[left];
                left+=1;
                
            }
            if(product < k )
            {
                ans = ans + (right - left + 1);
            }
        }
        return ans;
    }   
}
