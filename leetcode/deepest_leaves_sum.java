
class Solution {
    
    int ans=0;
    
    int height(TreeNode root)
    {
        if(root==null)
            return 0;
        else
            return 1+ Math.max(height(root.left),height(root.right));
    }
    
    void traverseTree(TreeNode root, int level, int h)
    {
       
        if(root==null)
            return ;
        
        if(level==h && root.left==null && root.right==null)
        { 
            ans+=root.val;
            return;
        }
        if(level==h)
            return;
        
        traverseTree(root.left,level+1,h);
        traverseTree(root.right,level+1,h);
        
        
    }
    
    
    public int deepestLeavesSum(TreeNode root)
    {
        int h = height(root);
        traverseTree(root,1,h);
        return ans;
        
        
    }
}
