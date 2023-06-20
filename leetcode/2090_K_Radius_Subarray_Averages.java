class Solution {
    public int[] getAverages(int[] nums, int k) 
    {
        long[] prefixSum = new long[nums.length+1];
        prefixSum[0] = 0;
        for(int i = 0; i< nums.length;++i)
        {
            prefixSum[i+1] = prefixSum[i] + (long)nums[i];
        }

        long[] ans = new long[nums.length];
        Arrays.fill(ans,-1l);
        // if(2*k + 1 > nums.length)
        //     return ans;

        for(int i=0;i<nums.length;++i)
        {
            if((i-k)< 0 || (i+k)>=nums.length)
            {
                ans[i] = -1l;
                continue;
            }
            else
            {
                ans[i] = (prefixSum[i+k+1] - prefixSum[i-k])/(2*k+1);
            }
        }
        int[] new_ans = new int[nums.length];
        for(int i=0;i<new_ans.length;++i)
        {
            new_ans[i] = (int)(ans[i]);
        }
        return new_ans;

    }
}.
