
class Solution {
public:
    
    int checkheight(TreeNode *root)
    {
        if(root==NULL)
            return -1;
        int left_height = checkheight(root->left);
        if(left_height==INT_MIN) return INT_MIN;
        
        int right_height=checkheight(root->right);
        if(right_height==INT_MIN) return INT_MIN;
        
        if(abs(right_height-left_height)>1)
            return INT_MIN;
        return max(left_height,right_height) +1;
    }
    
    
    bool isBalanced(TreeNode* root) 
    {
        return checkheight(root)!=INT_MIN;
    }
};
