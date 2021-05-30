class Solution {
    
    void countingsort(int[] nums, int exp)
    {
        int[] count = new int[10];
        int[] output = new int[nums.length];
        
        for(int num:nums)
        {
            count[(num/exp)%10]+=1;
        }
        for(int i=1;i<10;++i)
            count[i]+=count[i-1];
        for(int i=nums.length-1;i>=0;i--)
        {
            output[count[(nums[i]/exp)%10]-1] =nums[i];
            count[(nums[i]/exp)%10]-=1;
                
        }
        for(int i=0;i<nums.length;++i)
            nums[i] = output[i];
    }
    
    public int maximumGap(int[] nums) 
    {
        
        if(nums.length<2)
            return 0;
        
        int max =nums[0];
        for(int i=1;i<nums.length;++i)
            max = Math.max(nums[i],max);
        
        
        for(int exp=1;(max/exp)>0 ; exp*=10)
        {
            countingsort(nums,exp);
        }
        
        int diff = 0;
        for(int i=1;i<nums.length;++i)
            diff = Math.max(diff,Math.abs(nums[i]-nums[i-1]));
        
        return diff;
    }
}
