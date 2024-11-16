class Solution {
    public int[] resultsArray(int[] nums, int k) {
       
        int[] ans = new int[nums.length-k + 1]; 
        Arrays.fill(ans,-1);
       
        int l = 0;
        int r = 1;
        int cons_length=0;

        for(; r < k ; ++r)
        {
            if(nums[r] == (nums[r-1] +1))
            {
                cons_length+=1;
            }
        }

        if((cons_length+1) == k)
        {
            ans[l] = nums[k-1];
        }

        while(r<nums.length)
        {  
            if(nums[r] == (nums[r-1] +1))
                cons_length+=1;
            
            l+=1;
            if(nums[l] == (nums[l-1] + 1))
                cons_length-=1;
            
             if((cons_length+1) == k)
                ans[l] = nums[r];
            r+=1;

           
        }

        return ans;
    }
}
