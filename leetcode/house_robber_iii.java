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
    
    HashMap<TreeNode,Integer> dp = new HashMap<>();
    
    public int compute(TreeNode root)
    {
        if(root==null)
            return 0;
        if(dp.containsKey(root))
            return dp.get(root);
        
        int notrob =0;
        notrob = compute(root.left) + compute(root.right);
        int rob = root.val;
        if(root.left!=null && root.left.left!=null)
            rob += compute(root.left.left);
        if(root.left!=null && root.left.right!=null)
            rob += compute(root.left.right);
        if(root.right!=null && root.right.left!=null)
            rob += compute(root.right.left);
        
        if(root.right!=null && root.right.right!=null)
            rob += compute(root.right.right);

        dp.put(root, Math.max(rob,notrob));
        return dp.get(root);
      
    }
    
    
    
    public int rob(TreeNode root)
    {
        if(root==null)
	 return 0;
        
        return compute(root);
    }
}
