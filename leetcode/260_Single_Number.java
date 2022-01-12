class Solution {
    public int[] singleNumber(int[] nums) 
    {
        if(nums.length==2)
            return nums;
        
        int xor_result = 0;
        for(int i=0;i<nums.length;++i)
        {
            xor_result = xor_result ^ nums[i];
        }
        
        
        int odd_sum = 0;
        int even_sum = 0;
        
        int bit = 0;
        while((xor_result & 1) == 0)
        {
            xor_result>>=1;
            bit+=1;
        }
        
        for(int i=0;i<nums.length;++i)
        {
            if((nums[i] & (1<<bit)) > 0)
            {
                odd_sum = odd_sum ^ nums[i];
            }
            else
            {
                even_sum = even_sum ^ nums[i];
            }
        }
        return new int[]{odd_sum,even_sum};
        
    }
}
