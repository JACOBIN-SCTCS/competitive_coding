/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) 
    {
        vector<vector<int>> levelorder;
        queue<Node*> q;
        if(root==NULL)
            return levelorder;
        q.push(root);
        while(!q.empty())
        {
            int size = q.size();
            vector<int> current;
            for(int i=0;i<size;++i)
            {
                Node* curr = q.front();
                q.pop();
                current.push_back(curr->val);
                for(int j=0;j<curr->children.size();++j)
                {
                    q.push(curr->children[j]);
                }
            }
            levelorder.push_back(current);
        }
        return levelorder;
    }
};
