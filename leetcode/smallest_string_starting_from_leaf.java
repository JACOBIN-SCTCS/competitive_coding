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
    
    String ans=null;
    
    public void DFS(TreeNode root, StringBuilder sb)
    {
        if(root==null)
            return;
        sb.append((char)(root.val+'a'));
        if(root.left==null && root.right==null)
        {
            sb.reverse();
            String current = sb.toString();
            sb.reverse();
            
            if(ans==null)
                ans=current;
            else
            {
                if(current.compareTo(ans)<0)
                {
                    ans=current;
                }
            }
          
        }
        
        DFS(root.left,sb);
        DFS(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    
    
    public String smallestFromLeaf(TreeNode root) 
    {
        DFS(root,new StringBuilder());
        return ans;
    }
}
