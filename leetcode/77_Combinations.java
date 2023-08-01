class Solution {
    
    List<List<Integer>> ans;

    public void helper(int i, int n, int k, List<Integer> current_list)
    {
        
        if(i>n)
        {
            if(k==0)
            {
                List<Integer> new_list = new ArrayList<>(current_list);
                ans.add(new_list);
                return;
            }
            else
            {
                return;
            }

        }
        current_list.add(i);
        helper(i+1,n,k-1,current_list);
        current_list.remove(current_list.size()-1);
        helper(i+1,n,k,current_list);
    }

    public List<List<Integer>> combine(int n, int k) 
    {
        ans = new ArrayList<List<Integer>>();
        helper(1,n,k,new ArrayList<Integer>());


        return ans;
    }
}
