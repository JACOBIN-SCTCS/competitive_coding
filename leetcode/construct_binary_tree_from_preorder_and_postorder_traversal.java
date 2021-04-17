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
    public TreeNode constructFromPrePost(int[] pre, int[] post)
    {
        int n=pre.length;
        if(n==0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        if(n==1)
            return root;
        
        int l =0;
        for(int i=0;i<n;++i)
        {
            if(post[i]==pre[1])
            {
                l=i+1;
                break;
            }
        }
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,l+1), Arrays.copyOfRange(post,0,l));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,l+1,n),Arrays.copyOfRange(post,l,n-1));
        return root;
    }
}
