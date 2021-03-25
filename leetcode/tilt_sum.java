
class Solution {
    
    int tilt_sum = 0;
    
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        tilt_sum += Math.abs(left-right);
        return left+right+root.val;
    }
    
    public int findTilt(TreeNode root) 
    {
        int temp = helper(root);
        return tilt_sum;
    }
}
