
class Solution {
    
    TreeNode inOrderSuccessor(TreeNode root)
    {
        while(root.left!=null)
            root=root.left;
        return root;
    }
    
    
    public TreeNode deleteNode(TreeNode root, int key) 
    {
         if(root==null)
             return null;
        if(root.val==key)
        {
            if(root.left==null && root.right==null)
                return null;
            else if(root.left==null || root.right==null)
            {
                if(root.left==null)
                    return root.right;
                else
                    return root.left;
            }
            else
            {
                TreeNode successor = inOrderSuccessor(root.right);
                int tmp = successor.val;
                successor.val = root.val;
                root.val = tmp;
                root.right = deleteNode(root.right,key);
                return root;
            }
        }
        else if(root.val<key)
        {
            root.right = deleteNode(root.right,key);
        }
        else
        {
            root.left = deleteNode(root.left,key);
        }
            
        return root;
    }
}
