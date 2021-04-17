class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) 
    {

        vector<bool> reachable(n,false);
        for(int i=0;i<edges.size();++i)
        {
            reachable[edges[i][1]]=true;
        }
        
        vector<int> nodes;
        for(int i=0;i<n;++i)
        {
            if(reachable[i]==false)
            {
                nodes.push_back(i);
            }
        }
        return nodes;
    }
};
