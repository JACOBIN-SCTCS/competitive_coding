class Solution {
    public int minDifference(int[] nums) {
     
     int n = nums.length;
     if(nums.length <= 4)
     {
        return 0;
     }   

     int ans = Integer.MAX_VALUE;
     Arrays.sort(nums);
     
     ans = Math.min(ans,nums[n-1]-nums[3]);
     ans = Math.min(ans,nums[n-2]-nums[2]);
     ans = Math.min(ans,nums[n-3]-nums[1]); 
     ans = Math.min(ans,nums[n-4]-nums[0]); 
     return ans;
    }
}
