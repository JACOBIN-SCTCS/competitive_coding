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
class Solution 
{
    TreeNode prevNode = null;
    int ans =Integer.MAX_VALUE;

    public void inorder(TreeNode root)
    {
        if(root==null)
            return;

        inorder(root.left);
        if(prevNode != null)
        {
            ans = Math.min(ans,root.val -prevNode.val);
        }
        prevNode = root;
        inorder(root.right);
    }

    public int minDiffInBST(TreeNode root) 
    {
        inorder(root);
        return ans;
    }
}
