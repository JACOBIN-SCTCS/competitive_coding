
class Solution {
    
    int count=1;
    
    void DFS(TreeNode root,int current_maximum)
    {
            if(root==null)
                return;
            if(root.val>=current_maximum)
            {
                count+=1;
                current_maximum = root.val;
            }
            DFS(root.left,current_maximum);
            DFS(root.right,current_maximum);
    }
    
    
    public int goodNodes(TreeNode root)
    {
     
        if(root==null)
            return 0;
        count=1;
        DFS(root,root.val);
        return count-1;
        
    }
}
