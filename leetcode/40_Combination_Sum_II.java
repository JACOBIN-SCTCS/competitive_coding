class Solution {
    
    List<List<Integer>> ans ;

    public void backtrack(List<Integer> list, int[] candidates, int index, int target)
    {   
        if(target < 0)
            return;
        else if (target == 0)
        {
            ans.add(new ArrayList(list));
        }
        else
        {
            for(int i=index; i < candidates.length && target >= candidates[i];i++)
            {
                if(i > index && candidates[i] == candidates[i-1])
                    continue;
                list.add(candidates[i]);
                backtrack(list,candidates, i+1, target-candidates[i]);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       ans  = new ArrayList<List<Integer>>();
       List<Integer> list = new ArrayList<Integer>();
       Arrays.sort(candidates);
       backtrack(list,candidates,0,target);
       return ans; 
    }
}
