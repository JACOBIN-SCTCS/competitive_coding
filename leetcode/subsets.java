class Solution 
{

    sList<List<Integer>> subsets = new ArrayList<List<Integer>>();    
    
    public void solve(List<Integer> res,int[] nums, int idx)
    {
        if(idx==nums.length)
        {
            subsets.add(new ArrayList<Integer>(res));
            return;
        }
        
        List<Integer> first = new ArrayList<Integer>(res);
        List<Integer> second = new ArrayList<Integer>(res);
        
        first.add(nums[idx]);
        solve(first,nums,idx+1);
        solve(second,nums,idx+1);
        
    }
    
    
    public List<List<Integer>> subsets(int[] nums) 
    {
        solve(new ArrayList<Integer>(),nums,0);
        return subsets;
    }
}
