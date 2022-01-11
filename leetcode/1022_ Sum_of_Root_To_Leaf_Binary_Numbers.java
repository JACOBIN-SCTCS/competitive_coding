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
    
    int ans = 0;
    
    public void compute(TreeNode root, int sum)
    {
        if(root==null)
        {
            ans += sum ;
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            ans += ((sum<<1) | root.val) ;
            return;
        }
        
        if(root.left!=null)
            compute(root.left,((sum<<1) | root.val));
        if(root.right!=null)
        compute(root.right,((sum<<1) | root.val));

    }
    
    public int sumRootToLeaf(TreeNode root) 
    {
        
       compute(root,0);
        return ans;
    }
}
