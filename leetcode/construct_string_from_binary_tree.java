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
    public String tree2str(TreeNode root) 
    {
        
        if(root==null)
            return "";
        
        if(root.left==null && root.right==null)
            return ""+root.val;
        
        String ret=""+root.val;
        ret = ret + "(";
        ret = ret + tree2str(root.left);
        ret = ret + ")";
        
        if(root.right!=null)
        {
            ret = ret+"(";
            ret = ret + tree2str(root.right);
            ret = ret+")";
           
        }
         return ret;
    }
}
