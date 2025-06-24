class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) 
    {
        int n = nums.length;
        boolean[] indices = new boolean[n];
        for(int i=0; i < n; ++i)
        {
            if(nums[i] == key)
            {
                int start = Math.max(0, i-k);
                int end = Math.min(n-1, i+k);
                int ptr = start;
                while(ptr <= end)
                {
                    indices[ptr] = true;
                    ptr+=1;
                }
                    
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i < n; ++i)
        {
            if(indices[i])
                ans.add(i);
        }
        return ans;
    }
}
