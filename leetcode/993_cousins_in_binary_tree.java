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
    
    
    
    public boolean compute(TreeNode root, int val, List<Integer> path)
    {
        if(root==null)
            return false;
        
        if(root.val==val)
        {
            path.add(val);
            return true;
        }
        boolean left = compute(root.left,val,path);
        if(left)
        {
            path.add(root.val);
            return true;
        }
        boolean right = compute(root.right,val,path);
        if(right)
        {
            path.add(root.val);
            return true;
        }
    
        
        return false;
    }
        
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        List<Integer> path1 = new ArrayList<Integer>();  
        List<Integer> path2 = new ArrayList<Integer>();
        
        boolean l1 = compute(root,x,path1);
        boolean l2 = compute(root,y,path2);
        if(l1==false || l2==false || path1.size()!=path2.size())
            return false;
    
        if(path1.get(1)==path2.get(1))
            return false;
        return true;
        
    }
}
