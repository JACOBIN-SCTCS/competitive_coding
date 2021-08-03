class Solution {
    
    List<List<Integer>> res;
    
    public void compute(int[] nums, int idx, List<Integer> list)
    {
        
        res.add( new ArrayList(list) );
        for( int i = idx;i < nums.length; i++ )
        {
            if( i != idx && nums[i] == nums[i-1] )
                continue;
            list.add(nums[i]); 
            compute(nums,i+1,list);
            list.remove( list.size()-1);
        }
        
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        
        Arrays.sort(nums);
        res = new ArrayList<List<Integer>>();
        
        compute(nums,0,new ArrayList<Integer>());
        return res;
    }
}
