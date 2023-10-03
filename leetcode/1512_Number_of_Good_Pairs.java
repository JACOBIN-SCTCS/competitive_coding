class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int max_num = 0;
        int min_num = 101;

        for(int i=0;i<nums.length;++i)
        {
            count[nums[i]] +=1;
            max_num = Math.max(nums[i],max_num);
            min_num = Math.min(nums[i],min_num);
        }

        int ans = 0;
        for(int i=min_num ; i <= max_num ; ++i)
        {
            if(count[i] > 1)
            {
                ans =  ans + ((count[i]*(count[i]-1))/2);
            }
        }
        return ans ;

    }
}
