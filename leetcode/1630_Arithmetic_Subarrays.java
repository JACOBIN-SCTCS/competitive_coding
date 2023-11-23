class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) 
    {
        List<Boolean> ans = new ArrayList<Boolean>();

        for(int i=0;i<l.length;++i)
        {
            int[] tmp = new int[r[i]-l[i] + 1];
            for(int j=0;j<tmp.length;++j)
            {
                tmp[j] = nums[j + l[i]];
            }
            Arrays.sort(tmp);
            int diff = tmp[1] - tmp[0];
            boolean curr_ans = true;
            for(int j = 1 ; j < tmp.length;++j)
            {
                if((tmp[j] - tmp[j-1]) != diff)
                {
                    curr_ans = false;
                    break;
                }
            }
            ans.add(curr_ans);

        }
        return ans;

    }
}
