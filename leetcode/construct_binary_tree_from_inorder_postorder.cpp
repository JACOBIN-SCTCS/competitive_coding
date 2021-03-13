
class Solution {
public:
    
    int postidx = 0;
    
    
    int search(int val, vector<int>& inorder , int start,int end)
    {
        for(int i=start;i<=end;++i)
        {
            if(inorder[i]==val)
                return i;
        }
        return -1;
    }
    
    
    TreeNode* build(vector<int>& inorder, int instart, int inend, vector<int>& postorder)
    {
        if(instart>inend || postidx<0)
            return NULL;
        
        
        TreeNode* newnode = new TreeNode(postorder[postidx]);
        
        int searchidx=search(postorder[postidx],inorder,instart,inend);
        if(searchidx==-1)
            return NULL;
        
        postidx-=1;
        newnode->right = build(inorder,searchidx+1,inend,postorder);
        newnode->left = build(inorder,instart,searchidx-1,postorder);
        return newnode;
        
    }
        
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) 
    {
        
        if(inorder.size()!=postorder.size())
            return NULL;
        
        postidx = postorder.size()-1;
        return build(inorder,0,inorder.size()-1,postorder);
        
        
    }
};
