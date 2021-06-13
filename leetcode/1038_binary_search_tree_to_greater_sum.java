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
    
    int sum = 0 ;
    
    public void compute(TreeNode root)
    {
        if(root==null)
            return;
        compute(root.right);
        sum = sum+ root.val;
        root.val = sum;
        compute(root.left);
    }
    
    
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        compute(root);
        return root;
    }
}
