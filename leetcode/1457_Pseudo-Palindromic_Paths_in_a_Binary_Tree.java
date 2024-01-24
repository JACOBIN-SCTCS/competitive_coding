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
    
    int ans = 0;

    public void helper(TreeNode root , int parity)
    {
        if(root== null)
            return;
        
        if(root.left == null && root.right == null)
        {
            int new_parity = (parity) ^ (1 << root.val);
            int count = 0;
            for(int i=1; i <= 9; ++i)
            {
                if((new_parity & (1 << i ) )> 0)
                {
                    count+=1;
                }
            }
            if(count <= 1)
                ans +=1;   
        }
        
        int new_parity  = parity ^ (1<<root.val);
        helper(root.left, new_parity);
        helper(root.right , new_parity);
    }
    
    
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        helper(root,0);
        return ans;
    }
}
