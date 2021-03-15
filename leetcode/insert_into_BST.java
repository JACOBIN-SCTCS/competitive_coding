
class Solution {
    
    
    
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        TreeNode newnode = new TreeNode(val,null,null);
        if(root==null)
            return newnode;
        
        
        TreeNode ptr=root;
        TreeNode parent=null;
        while(ptr!=null)
        {
            parent=ptr;
            if(ptr.val<val)
                ptr=ptr.right;
            else if(ptr.val>val)
                ptr=ptr.left;
        }
        
        if(parent.val<val)
        {
            parent.right=newnode;
        }
        else
        {
            parent.left=newnode;
        }
        return root;
        
    }
}
