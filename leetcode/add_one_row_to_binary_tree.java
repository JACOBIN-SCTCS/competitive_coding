
class Solution {
    
    public void DFS(TreeNode root,int v , int d , int level)
    {
        if(root==null)
            return;
        
        if((level+1)==d)
        {
            TreeNode node_left=new TreeNode(v,root.left,null);
            TreeNode node_right = new TreeNode(v,null,root.right);
            root.left=node_left;
            root.right=node_right;
        
        }
        else
        {
            DFS(root.left,v,d,level+1);
            DFS(root.right,v,d,level+1);   
        }

    }
    
    
    public TreeNode addOneRow(TreeNode root, int v, int d) 
    {
        
        
        if(d==1)
        {
            TreeNode newnode = new TreeNode(v,root,null);
            return newnode;
        }
        DFS(root,v,d,1);
        return root;
       
        
    }
}
