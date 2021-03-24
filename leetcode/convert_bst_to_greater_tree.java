
class Solution {
    
    int sum =0;
    
    public void computesum(TreeNode root)
    {
        if(root==null)
            return;
        
        computesum(root.right);
        sum+=root.val;
        root.val = sum;
        computesum(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) 
    {
        computesum(root);
        return root;
    }
}
