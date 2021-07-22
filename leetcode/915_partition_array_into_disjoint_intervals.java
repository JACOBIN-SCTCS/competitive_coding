class Solution {
    public int partitionDisjoint(int[] nums) {
     
        int[] aux = new int[nums.length];
        aux[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            aux[i] = Math.min(nums[i],aux[i+1]);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;++i)
        {
            res = Math.max(res,nums[i]);
            if(res<= aux[i+1])
                return i+1;
        }
        return nums.length;
        
    }
}
