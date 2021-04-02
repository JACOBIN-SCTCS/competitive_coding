class Solution {
    
    HashSet<List<Integer>> perm = new HashSet<List<Integer>>();
    
    
    public void generatePermutations(int[] nums, boolean[] chosen, List<Integer> list)
    {
        if(list.size()==nums.length)
        {
            perm.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<chosen.length;++i)
        {
            if(chosen[i]==false)
            {
                
                list.add(nums[i]);
                chosen[i]=true;
                generatePermutations(nums,chosen,list);
                chosen[i]=false;
                list.remove(list.size()-1);
            }
        }
            
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        boolean[] chosen = new boolean[nums.length];
        generatePermutations(nums,chosen, new ArrayList<Integer>());
        List<List<Integer>> ret_list = new ArrayList<List<Integer>>(perm);
        return ret_list;
        
        
    }
}
