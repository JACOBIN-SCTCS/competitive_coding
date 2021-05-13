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
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
        if(root==null)
            return ret_list;
    
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;++i)
            {
                TreeNode curr =q.remove();
                list.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            ret_list.add(list);
        }
        Collections.reverse(ret_list);
        return ret_list;
    }
}
