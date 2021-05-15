/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    TreeNode flattenUtil(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode left = flattenUtil(root.left);
        TreeNode right = flattenUtil(root.right);
        
        
        root.left=root.right=null;
        if(left==null && right==null)
            return root;
        else if(left==null || right==null)
        {
            if(left==null)
                root.right=right;
            else
                root.right=left;
        }
        else
        {
            root.right=left;
            TreeNode ptr = left;
            while(ptr.right!=null)
                ptr = ptr.right;
            ptr.right=right;
        }
        return root;
        
        
    }
    public void flatten(TreeNode root) 
    {
        TreeNode newroot = flattenUtil(root);
        return;
    }
}
