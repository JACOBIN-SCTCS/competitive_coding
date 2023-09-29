class Solution {
    public boolean isMonotonic(int[] nums) {
        int state = 0;

        for(int i=1; i< nums.length; ++i)
        {
            int diff = nums[i] - nums[i-1];
            if(diff != 0)
            {
                if(state !=0)
                {
                    int new_state = (diff < 0) ? -1 : 1;
                    if(new_state != state)
                        return false;
                }
                else
                {
                    state = (diff < 0) ? -1 : 1;
                }
            }
        }
        return true;
    }
}
