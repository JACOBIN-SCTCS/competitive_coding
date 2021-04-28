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
    
    HashMap<Integer,Integer> map_sum = new HashMap<>();
    
   
    public void traverseTree(TreeNode root, int level)
    {
        if(root==null)
            return;
        
        if(map_sum.containsKey(level))
        {
            map_sum.put(level,map_sum.get(level)+root.val);
        }
        else
        {
            map_sum.put(level,root.val);
        }
        traverseTree(root.left,level+1);
        traverseTree(root.right,level+1);
    }
    
    public int maxLevelSum(TreeNode root) 
    {
        traverseTree(root,1);
        int ans =Integer.MIN_VALUE;
        int idx=-1;
        for(int key:map_sum.keySet())
        {
            if(map_sum.get(key)>ans)
            {
                ans=map_sum.get(key);
                idx=key;
            }
        }
        return idx;
    }
}
