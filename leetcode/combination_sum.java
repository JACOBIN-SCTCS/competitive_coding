import java.util.Arrays;

class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    
    public void generateCombinations(int target,List<Integer> list,int[] set,int index)
    {
        if(target<0)
            return;
        
        if(target==0)
        {
            
            List<Integer> a = new ArrayList<Integer>();
            a.addAll(list);
            
            result.add(a);
            return;
        }
        
        
        for(int i=index;i<set.length;++i)
        {
            /*List<Integer> new_list = new ArrayList<Integer>();
            new_list.addAll(list);
            new_list.add(s);
            generateCombinations(target-s,new_list,set);*/
            
            if(target<set[i])
                return;
            
            list.add(set[i]);
            generateCombinations(target-set[i],list,set,i);
            list.remove(list.size()-1);
                
        }
        
        
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
       
        List<Integer> n = new ArrayList<Integer>();
        Arrays.sort(candidates);
        generateCombinations(target,n,candidates,0);
        return result;
        
    }
}
