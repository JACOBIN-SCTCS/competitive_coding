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
    int ans = 1;
    public int helper(TreeNode root, boolean left)
    {
        if(root== null)
            return 0;
        
        int l = 1 + helper(root.left,true);
        int r = 1 + helper(root.right,false);

        ans = Math.max(ans,Math.max(l,r));

        if(left==true)
            return r;
        else
            return l;

    }   
    public int longestZigZag(TreeNode root) 
    {
        int tmp = helper(root,true);
        return ans-1;
    }
}
