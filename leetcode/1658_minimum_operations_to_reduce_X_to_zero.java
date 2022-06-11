class Solution {
    public int minOperations(int[] nums, int x) 
    {
        long sum = 0;
        for(int i=0;i<nums.length;++i){
            sum = sum + nums[i];
        }
    
        int start_idx= 0;
        int end_idx = 0;
        
        long run_sum = 0l;
        int max_length = -1;
        
        for(end_idx =0 ; end_idx < nums.length; ++end_idx) {
            run_sum += nums[end_idx];
            while(start_idx <= end_idx && run_sum > (sum-x)) {
                run_sum -= nums[start_idx];
                start_idx+=1;
            }
            if(run_sum == (sum-x)) {
                max_length = Math.max(max_length,end_idx-start_idx+1);
            }
        }
        if(max_length==-1) {
            return -1;
        }
        else
        {
            return nums.length-max_length;
        }

    }
}
