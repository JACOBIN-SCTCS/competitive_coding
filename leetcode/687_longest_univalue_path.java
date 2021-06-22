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
    
    int ans = 1;
    
    public int compute(TreeNode root)
    {
          if(root==null)
             return 0;
        
        int left = compute(root.left);
        int right = compute(root.right);
        
        if(root.left!=null && root.left.val==root.val 
           && root.right!=null && root.right.val == root.val)        
        {
            ans = Math.max(ans,left+right+1);
            return (Math.max(left,right)+1);
        }
        
        if(root.left!=null && root.left.val == root.val)
        {
            ans = Math.max(ans,1+left);
            return (1+left);
        }
        if(root.right!=null && root.right.val == root.val)
        {
            ans = Math.max(ans,1+right);
            return 1+right;
        }
        
        
        return 1;
    }
    
    public int longestUnivaluePath(TreeNode root) 
    {
         ans = 1;
        int sample = compute(root);
        return (ans-1);
    }
}
