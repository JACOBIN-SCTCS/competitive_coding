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
    
    int idx=0;
    
    int find(int[] inorder , int ele)
    {
        for(int i=0;i<inorder.length;++i)
        {
            if(inorder[i]==ele)
                return i;
        }
        return -1;
    }
    
    public TreeNode solve(int[] preorder, int[] inorder)
    {
        if(idx>=preorder.length || inorder.length==0)
            return null;
    
        int inorder_idx = find(inorder,preorder[idx]);
        if(inorder_idx==-1)
            return null;
        
        TreeNode root = new TreeNode(preorder[idx]);
        idx+=1;
        int[] left = Arrays.copyOfRange(inorder,0,inorder_idx);
        int[] right = Arrays.copyOfRange(inorder,inorder_idx+1,inorder.length);
        
        root.left = solve(preorder,left);
        root.right = solve(preorder,right);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        idx=0;
         return solve(preorder,inorder); 
    }
}
