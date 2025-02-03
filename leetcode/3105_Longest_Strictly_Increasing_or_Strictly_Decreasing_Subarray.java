class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];

        int max_inc = 1;
        int max_dec = 1;
        inc[0] = 1;
        dec[0] = 1;

        for(int i=1 ; i < nums.length; ++i)
        {
            if(nums[i-1] > nums[i])
            {
                dec[i] = dec[i-1] + 1;
                inc[i] = 1;
            }
            else if (nums[i-1] < nums[i])
            {
                inc[i] = inc[i-1] + 1;
                dec[i] = 1;
            }
            else
            {
                inc[i] = 1;
                dec[i] = 1;
            }
            max_inc = Math.max(max_inc,inc[i]);
            max_dec = Math.max(max_dec,dec[i]);
        }
        return Math.max(max_inc, max_dec);

    }
}
