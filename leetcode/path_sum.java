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
    
    
    public boolean valid(TreeNode root,int sum,int targetSum)
    {
         if(root==null)
           {
              return false; 
           }
        
          if(root.left==null && root.right==null)
          {
              sum = sum+root.val;
              if(targetSum==sum)
                  return true;
              else
                  return false;
          }
        
        
        
        return valid(root.left,sum+root.val,targetSum) ||
                valid(root.right,sum+root.val,targetSum);
    }
    
    
    
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
          if(root==null)
             return false;
        
        return valid(root,0,targetSum);
    }
}
