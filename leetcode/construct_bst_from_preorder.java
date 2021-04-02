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
    
    TreeNode treeroot=null;
    
    public void insertIntoTree(TreeNode root, TreeNode parent, int val)
    {
      
        if(parent==null)
        {
            TreeNode newnode = new TreeNode(val);
            treeroot=newnode;
            return;
        }
        
        if(root==null)
        {
            TreeNode newnode = new TreeNode(val);
            if(parent.val<val)
                parent.right=newnode;
            else
                parent.left= newnode;
            
            return;
        }
        else
        {
            if(root.val<val)
            {
               insertIntoTree(root.right,root,val);
            }
            else
            {
                insertIntoTree(root.left,root,val);
            }
        }
            
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder)
    {
      
        for(int val: preorder)
        {
            insertIntoTree(treeroot,treeroot,val);
        }
        return treeroot;
        
    }
}
