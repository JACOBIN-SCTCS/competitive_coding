class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) 
    {
        int[] delta = new int[nums.length+1];
        for(int[] query : queries)
        {
            delta[query[0]] += 1;
            delta[query[1]+1] -= 1; 
        }
        int prefixsum = 0;

        for(int i= 0 ; i < nums.length; ++i)
        {
            prefixsum = prefixsum + delta[i];
            if((nums[i] - prefixsum) > 0)
                return false;
        }
        return true;
    }
}
