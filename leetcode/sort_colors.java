class Solution {
    
    public void sortColors(int[] nums) 
    {
        int[] count = new int[3];
        for(int c:nums)
            count[c]+=1;
        
        int i =0; 
        int idx=0;
        while(i<nums.length && idx<3)
        {
            if(count[idx]==0)
            {
                while(count[idx]==0)
                    idx+=1;
            }
            nums[i]=idx;
            count[idx]-=1;
            i++;
        }
      
        
    }
}
