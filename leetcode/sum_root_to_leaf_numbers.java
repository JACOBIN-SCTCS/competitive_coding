class Solution {
    
    int ans;
    
    public void DFS(TreeNode root, int value)
    {
        if(root==null)
            return;
        
        int new_value = value*10+root.val;
        if(root.left==null && root.right==null)
            ans += new_value;
        
        
        DFS(root.left,new_value);
        DFS(root.right,new_value);
        
        
    }
    
    
    public int sumNumbers(TreeNode root) 
    {
        if(root==null)
            return 0;
        
        ans=0;
        DFS(root,0);
        return ans;
    }
}
