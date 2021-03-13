class Solution {
public:
 
    
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) 
    {
        if(n<=2)
        {
            vector<int> ret_list;
            for(int i=0;i<n;++i)
                ret_list.push_back(i);
            return ret_list;
        }
        
        set<int> adj_list[n];
        for(int i=0;i<edges.size();++i)
        {
            adj_list[edges[i][0]].insert(edges[i][1]);
            adj_list[edges[i][1]].insert(edges[i][0]);
       
        }
        
        
        vector<int> leaves;
        for(int i=0;i<n;++i)
        {
            if(adj_list[i].size()==1)
            {
                leaves.push_back(i);
            }
        }
        
        int remaining_nodes = n;
        while(remaining_nodes>2)
        {
            vector<int> newleaves;
            remaining_nodes-=leaves.size();
            
            for(int i=0;i<leaves.size();++i)
            {
                for(auto ele : adj_list[leaves[i]])
                {
                    adj_list[ele].erase(leaves[i]);
                    if(adj_list[ele].size()==1)
                    {
                        newleaves.push_back(ele);
                    }
                }
            }
            
            leaves=newleaves;
        }
        return leaves;
        
        
        
        
    }
};
