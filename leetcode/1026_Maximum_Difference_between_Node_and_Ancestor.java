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
class Data
{
    int min;
    int max;
    
    Data(int min, int max)
    {
        this.min = min;
        this.max = max;
    }
}

class Solution {
    
    int ans = 0;
    
    Data helper(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            Data d = new Data(root.val,root.val);
            return d;
        }
        else if(root.left==null || root.right==null)
        {
            if(root.left==null)
            {
                Data right = helper(root.right);
                ans = Math.max(ans,Math.abs(root.val-right.min));
                ans = Math.max(ans,Math.abs(root.val - right.max));
                return new Data(Math.min(right.min,root.val),Math.max(right.max,root.val));
                
            }
            else
            {
                Data left = helper(root.left);
                ans = Math.max(ans,Math.abs(root.val-left.min));
                ans = Math.max(ans,Math.abs(root.val - left.max));
                return new Data(Math.min(left.min,root.val),Math.max(left.max,root.val));
                
            }
        }
        Data left = helper(root.left);
        Data right = helper(root.right);
        
        int min = Math.min(left.min,right.min);
        int max = Math.max(left.max,right.max);
        
        ans = Math.max(ans,Math.abs(root.val-min));
        ans = Math.max(ans,Math.abs(root.val-max));
        
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        return new Data(min,max);
        
        
    }
    
    public int maxAncestorDiff(TreeNode root) 
    {
         Data d = helper(root);
         return ans;
    }
}
