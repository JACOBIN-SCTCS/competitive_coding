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

    public int helper(TreeNode root, int direction)
    {
        if(root == null)
            return 0;
        
        if(root.left==null && root.right == null && direction == 1)
            return root.val;
        int ans1 = helper(root.left,1);
        int ans2 = helper(root.right,0);

        return ans1+ ans2;
        
    }
    public int sumOfLeftLeaves(TreeNode root) 
    {
        int ans = helper(root,0);
        return ans;    
    }
}
