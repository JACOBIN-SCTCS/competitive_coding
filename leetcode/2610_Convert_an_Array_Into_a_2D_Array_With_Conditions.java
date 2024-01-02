class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] table = new int[nums.length + 1];

        int max_ans = 1;
        for(int i=0 ; i < nums.length; ++i)
        {
            table[nums[i]]+=1;
            max_ans = Math.max(max_ans,table[nums[i]]);
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0 ; i < max_ans ; ++ i)
            ans.add(new ArrayList<Integer>());

        for(int i=1; i <= nums.length ; ++i)
        {
            if(table[i] > 0)
            {
                int idx = 0;
                while(idx < table[i])
                {
                    ans.get(idx).add(i);
                    idx+=1;
                }
            }
        }
        return ans;

    }
}
