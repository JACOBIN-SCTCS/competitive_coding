
class Solution {
public:
    bool isEvenOddTree(TreeNode* root)
    {
        
        if(root==NULL)
            return true;
        
        int current_level=0;
        queue<pair<TreeNode*,int>> q;
        int current_element=0;
        
        q.push({root,current_level});
        
        while(!q.empty())
        {
            pair<TreeNode*,int> node = q.front();
            q.pop();
            
            
            if(node.second!=current_level)
            {
                current_level=node.second;
                if(current_level%2==0)
                {
                    if(node.first->val%2!=1)
                        return false;
                }
                else
                {
                     if(node.first->val%2!=0)
                        return false;
                }
              
            }
            else
            {
                if(current_level%2==0)
                {
                    if(node.first->val<=current_element)
                        return false;
                    if(node.first->val%2==0)
                        return false;
                        
                        
                }
                else
                {
                     if(node.first->val>=current_element)
                        return false;
                    if(node.first->val%2==1)
                        return false;
                }
            }
            current_element=node.first->val;
            if(node.first->left!=NULL)
                q.push({node.first->left,current_level+1});
                
            if(node.first->right!=NULL)
                q.push({node.first->right,current_level+1});


            
        }
        
        
        
        return true;
    }
};
