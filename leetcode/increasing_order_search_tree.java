class Solution {
    
    List<TreeNode> list ;
    
    public void InOrder(TreeNode root)
    {
        if(root==null)
            return;
        
        InOrder(root.left);
        list.add(root);
        InOrder(root.right);
    }
    
    public TreeNode increasingBST(TreeNode root) 
    {
        list = new ArrayList<>();
        InOrder(root);
        TreeNode newroot;
        TreeNode parent = new TreeNode(-1);
        newroot=parent;
        for(TreeNode curr : list)
        {
            parent.right=curr;
            curr.left=null;
            parent=curr;
        }
        return  newroot.right;
    }
}
