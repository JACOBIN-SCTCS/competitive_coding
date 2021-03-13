class Solution {
    public int minElements(int[] nums, int limit, int goal) 
    {
        long sum=0;
        
        for(int num:nums)
            sum+=num;
        
        if(sum==goal)
            return 0;
        
        
        long rem = Math.abs(sum-goal);
        if(rem<=limit)
            return 1;
        
        long mod = rem%((long) limit)>0?1:0;
        
        long count = (rem/limit)+mod;
        return (int)count;
        
        
        
    }
}
