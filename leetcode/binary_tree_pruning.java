class Solution {
    
    boolean containsOne(TreeNode root)
    {
        if(root==null)
            return false;
        
        
        boolean left = containsOne(root.left);
        if(left==false)
            root.left=null;
        
        boolean right = containsOne(root.right);
        if(right==false)
            root.right=null;
        
        return root.val==1 || right||left;
        
    }
    
    public TreeNode pruneTree(TreeNode root) 
    {
            boolean ret = containsOne(root);
            if(ret==true)
                return root;
            return null;
    }
}
