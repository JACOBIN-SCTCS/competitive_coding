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
    
    int ans =0 ;
    
    public int helper(TreeNode root)
    {
         if(root==null)
            return 0;
        int left = (root.left==null)?0:1+helper(root.left);
        int right = (root.right==null)?0:1+helper(root.right);
        
        ans = Math.max(left,ans);
        ans  =Math.max(ans,right);
        ans = Math.max(ans,left+right);
        
        return Math.max(left,right);
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) 
    {
       helper(root);
        return ans;
    }
}
