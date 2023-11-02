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
    class Value
    {
        int num_nodes;
        int sum;
        Value(int num_nodes, int sum)
        {
            this.num_nodes = num_nodes;
            this.sum = sum;
        }
    }

    int ans;

    public Value helper(TreeNode root)
    {
        if(root==null)
        {
            return new Value(0,0);
        }
        Value left = helper(root.left);
        Value right = helper(root.right);

        int total_sum = left.sum + right.sum + root.val;
        int num_nodes = left.num_nodes + right.num_nodes + 1;

        int avg = (total_sum) / num_nodes;
        if(avg == root.val)
            ans+=1;
        return new Value(num_nodes,total_sum);

    }
    
    
    public int averageOfSubtree(TreeNode root) {
       ans = 0; 
       Value val = helper(root);
       return ans;
    }
}
