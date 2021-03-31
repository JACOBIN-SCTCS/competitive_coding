
class Solution
{
    
    List<Integer> ans = new ArrayList<Integer>();
    int index=0;
  
    
    
    public void solve(TreeNode root, int[] voyage)
    {
        if(root==null || index==voyage.length)
            return;
        
        if(root.val!=voyage[index])
        {
            ans = new ArrayList<Integer>();
            ans.add(-1);
            return;
        }
        
        index+=1;
        
        if(index>=voyage.length)
            return;
        
        if(root.left!=null && root.left.val!=voyage[index])
        {
            ans.add(root.val);
            solve(root.right,voyage);
            solve(root.left,voyage);
            
            
        }
        else
        {
            solve(root.left,voyage);
            solve(root.right,voyage);
        }

        
    }
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) 
    {
        index=0;
        solve(root,voyage);
        
        if (ans.size()>0 && ans.get(0)==-1)
        {
            ans = new ArrayList<Integer>();
            ans.add(-1);
            return ans;
        }
        else
        {
            return ans;
        }
        
    }
}
