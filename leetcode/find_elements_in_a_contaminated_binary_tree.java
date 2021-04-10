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
class FindElements 
{
    HashSet<Integer> set ;

    public void DFS(TreeNode root)
    {
        if(root==null)
            return;
        
        set.add(root.val);
        if(root.left!=null)
        {
            root.left.val = root.val*2+1;
            DFS(root.left);
        }
        if(root.right!=null)
        {
            root.right.val=root.val*2+2;
            DFS(root.right);
        }
    }
    
    
    public FindElements(TreeNode root)
    {
        set = new HashSet<Integer>();
        if(root!=null)
        {
            root.val=0;
            DFS(root);
        }
    }
    
    public boolean find(int target) 
    {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
