class Solution {
    public int waysToSplitArray(int[] nums) {
       
        long sum = 0;
        int ans = 0;

        for(int i=0; i < nums.length ; ++i)
            sum =  sum + nums[i];
        
        long running_sum = 0;
        for(int i = 0 ; i < nums.length-1; ++i)
        {
            running_sum = running_sum + nums[i];

           if(running_sum  >= (sum - running_sum))
                ans +=1;

        }
        return ans;
    }
}
