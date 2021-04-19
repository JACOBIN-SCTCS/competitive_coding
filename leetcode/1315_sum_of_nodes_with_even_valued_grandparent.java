/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {

    public:
    
    int compute(TreeNode *grandpa, TreeNode *parent,TreeNode *root)
    {
        if(root==NULL)
            return 0;
        if(parent==NULL)
        {
            return compute(NULL,root,root->left) + compute(NULL,root,root->right);
        }
        if(grandpa==NULL)
        {
            return compute(parent,root,root->left) + compute(parent,root,root->right);
        }
        
        if(grandpa->val %2==0)
        {
            return root->val + compute(parent,root,root->left) + compute(parent,root,root->right);
        }
        else
        {
            return compute(parent,root,root->left) + compute(parent,root,root->right);
        }
    }
    
    
    int sumEvenGrandparent(TreeNode* root) 
    {
        return compute(NULL,NULL,root);
    }
};
