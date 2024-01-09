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
    
    List<Integer> tree1;
    List<Integer> tree2;

    public void getLeaves(TreeNode root, boolean list1)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(list1)
                tree1.add(root.val);
            else
                tree2.add(root.val);

            return;
        }    
        
        getLeaves(root.left,list1);
        getLeaves(root.right,list1);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        tree1 = new ArrayList<Integer>();
        tree2 = new ArrayList<Integer>();

        getLeaves(root1,true);
        getLeaves(root2, false);
    
        if(tree1.size() != tree2.size())
            return false;
        for(int i =0 ; i < tree1.size() ; ++i)
        {
            if(tree1.get(i) != tree2.get(i))
                return false;
        }

        return true;
    }
}
