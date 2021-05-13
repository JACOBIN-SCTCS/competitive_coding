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
   
    int max_level = 0;
    int max_val = 0;
    
    void DFS(TreeNode root, int level)
    {
        if(root==null)
            return ;
        if(root.left==null && root.right==null && level>max_level)
        {
            max_level=level;
            max_val = root.val;
            return ;
        }
        if(root.left==null && root.right!=null)
        {
            DFS(root.right,level+1);
            return;
        }
        DFS(root.left, level+1);
        DFS(root.right,level+1);
        return ;
        
    }
    
    public int findBottomLeftValue(TreeNode root)
    {
       if(root==null)
           return 0;
        DFS(root,1);
        return max_val;
    }
}
