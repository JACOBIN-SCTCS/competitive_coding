class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] temp = new int[nums.length];
        int pptr = 0;
        int rptr = nums.length / 2 ;

        for(int i=0; i < nums.length; ++i)
        {
            if(nums[i] < 0)
            {
                temp[rptr++] = nums[i]; 
            }
            else
            {
                temp[pptr++] = nums[i];
            }

        }

        for(int i=0; i < nums.length; i+=2)
        {
            nums[i] = temp[i/2];
            nums[i+1] = temp[nums.length/2 + i / 2];
        }
        return nums;
    
    }
}
