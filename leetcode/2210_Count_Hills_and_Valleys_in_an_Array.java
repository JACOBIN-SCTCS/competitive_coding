class Solution {
    public int countHillValley(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];

        left[0] = -1;
        right[n-1] = -1;

        for(int i=1; i < nums.length; ++i)
        {
            if(nums[i] != nums[i-1])
            {
                left[i] = nums[i-1];
            }
            else
            {
                left[i] = left[i-1];
            }   
        }

        for(int i = n-2; i>=0; i--)
        {
            if(nums[i] != nums[i+1])
            {
                right[i] = nums[i+1];
            }
            else
            {
                right[i] = right[i+1];
            }  
        }

      

        for(int i=1; i < n-1; ++i) {
            if(left[i] > 0 && right[i] > 0 && nums[i] != nums[i-1])
            {
                if((nums[i] > left[i] && nums[i] > right[i])|| 
                (nums[i] < left[i] && nums[i] < right[i])) 
                {
                    ans +=1;
                }
            }
        }

        
        return ans;
    }
}
