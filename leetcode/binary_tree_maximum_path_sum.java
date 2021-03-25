
class Solution {
    
    int max_path_sum =  Integer.MIN_VALUE;
    
    public int path_sum(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int left = path_sum(root.left);
        int right = path_sum(root.right);
        
        max_path_sum = Math.max(max_path_sum,left+root.val);
        max_path_sum = Math.max(max_path_sum,right+root.val);
        max_path_sum = Math.max(max_path_sum,left+right+root.val);
        max_path_sum = Math.max(max_path_sum,root.val);

        return Math.max(root.val , Math.max(root.val+left,root.val+right));
        
        
    }
    
    public int maxPathSum(TreeNode root)
    {
        int random = path_sum(root);
        return max_path_sum;
    }
}
