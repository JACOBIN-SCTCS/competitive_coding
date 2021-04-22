class Solution {
   
    HashSet<List<Integer>> ret_list = new HashSet<List<Integer>>();
    
    void compute(int[] nums,int index, List<Integer> list)
    {
        if(index>=nums.length)
        {
            if(list.size()>=2)
            {
                ret_list.add(new ArrayList<Integer>(list));
            }
        }
        else
        {
            if(list.size()==0)
            {
                list.add(nums[index]);
                compute(nums,index+1,list);
                list.remove(list.size()-1);
                compute(nums,index+1,list);
            }
            else
            {
                if(list.get(list.size()-1)<=nums[index])
                {
                    list.add(nums[index]);
                    compute(nums,index+1,list);
                    list.remove(list.size()-1);
                }
                compute(nums,index+1,list);
            }
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        compute(nums,0,new ArrayList<Integer>());
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> res : ret_list)
            result.add(res);
        return result;
    }
}
