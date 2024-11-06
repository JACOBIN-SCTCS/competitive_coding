class Solution {
    public boolean canSortArray(int[] nums) {
    
        int bit_count = Integer.bitCount(nums[0]);
        int seg_min = Integer.MAX_VALUE;
        int seg_max = Integer.MIN_VALUE;
        int prev_max = 0;
    
        for(int i=0; i < nums.length; ++i)
        {
            int num = nums[i];
            int current_bit_count = 0;
            while(num > 0)
            {
                if((num & 1) == 1)
                    current_bit_count +=1;
                num >>=1;
            }
            num = nums[i];
            if(current_bit_count != bit_count)
            {
               
               
                 if(prev_max > seg_min)
                    return false;
                prev_max = seg_max;
                seg_min = num;
                seg_max = num;

            }
            else
            {
                seg_min = Math.min(seg_min, num);
                seg_max = Math.max(seg_max, num);
            }
            bit_count = current_bit_count;
            
        }
        
        if(prev_max > seg_min)
            return false;
        return true;


    }
}
