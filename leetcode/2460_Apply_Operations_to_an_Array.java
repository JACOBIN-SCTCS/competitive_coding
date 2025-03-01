class Solution {
    public int[] applyOperations(int[] nums) {
        
        for(int i=0; i < nums.length; ++i)
        {
            if((i+1) < nums.length && nums[i] == nums[i+1] && nums[i]!=0)
            {
                nums[i] *=2 ;
                nums[i+1] = 0;
            }
        }

        int nonZeroIndex = 0;
        
        for(int i=0; i < nums.length;++i)
        {
            if(nums[i]!=0)
            {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex+=1;
            }
        }
        while(nonZeroIndex < nums.length)
            nums[nonZeroIndex++] = 0;
            
        return nums;
    }
}
