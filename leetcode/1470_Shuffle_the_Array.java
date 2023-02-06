class Solution {
    public int[] shuffle(int[] nums, int n) 
    {
       // O(1) space solution was looked up in Discussion section

        for(int i=n;i<2*n;++i)
        {
            int second_num =  nums[i]<<10;
            nums[i-n] |= second_num;
        }

        int all_ones = (int) Math.pow(2, 10) - 1;
        for(int i=n-1;i>=0;i--)
        {
            int second_num = nums[i] >> 10;
            int first_num = nums[i] & all_ones;

            nums[2*i] = first_num;
            nums[2*i+1] = second_num;
            
        }
        return nums;
    }
}
