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
    
    int prev_ele = -1;
    int ans = Integer.MAX_VALUE;

    public void helper(TreeNode root)
    {
        if(root==null)
            return;

        helper(root.left);
        if(prev_ele!=-1)
        {
            int difference = Math.abs(root.val-prev_ele);
            ans = Math.min(ans,difference);
            prev_ele = root.val;

        }
        else
        {
            prev_ele = root.val;
        }
  
        helper(root.right);

    }

    public int getMinimumDifference(TreeNode root) 
    {
        helper(root);
        return ans;
    }
}
