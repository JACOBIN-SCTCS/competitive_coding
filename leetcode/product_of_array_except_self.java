class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int[] prefix_product = new int[nums.length];
        int[] suffix_product = new int[nums.length];        
        
        suffix_product[nums.length-1]=1;
        prefix_product[0] =1;
        
        for(int i=1;i<nums.length;++i)
        {
            prefix_product[i] = prefix_product[i-1]*nums[i-1];
        }
        
        for(int i=nums.length-2;i>=0;i--)
        {
            suffix_product[i] = suffix_product[i+1]*nums[i+1];
        }
        
        
        int[] ret = new int[nums.length];
        for(int i=0;i<nums.length;++i)
        {
            ret[i] = suffix_product[i]*prefix_product[i];
        }
        
        return ret;
    }
}
