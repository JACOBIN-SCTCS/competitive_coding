
class Solution 
{
    
    
    List<Integer> rightview  = new ArrayList<Integer>();
    
    public void DFS(TreeNode root, int level)
    {
        if(root==null)
            return;
        
        if(rightview.size()==level)
        {
           rightview.add(root.val); 
        }
        
        DFS(root.right,level+1);
        DFS(root.left,level+1);
    }
    
    
    public List<Integer> rightSideView(TreeNode root)
    {
        DFS(root,0);
        return rightview;
        
    }
}
