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
    
    List<TreeNode> result = new ArrayList<>();
    
    public TreeNode DFS(TreeNode root, Set<Integer> elements)
    {
        if(root==null)
            return null;
        root.left = DFS(root.left,elements);
        root.right = DFS(root.right,elements);
        if(elements.contains(root.val))
        {
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete)
    {
        if(root==null)
            return null;
        
        Set<Integer> elements = new HashSet<>();
        for(int ele:to_delete)
            elements.add(ele);
        
        
        if(!(elements.contains(root.val)))
        {
            result.add(root);
        }
        
        DFS(root,elements);
        
        return result;
    }
}
