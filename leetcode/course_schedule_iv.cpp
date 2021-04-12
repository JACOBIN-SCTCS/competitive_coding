class Solution {
public:
    
    bool DFS(vector<int> adj[],int source,int destination,vector<bool> &visited)
    {
       
        if(source==destination )
            return true;
        if(visited[source]==true)
            return false;
      
        visited[source]=true;
        
        for(int i=0;i<adj[source].size();++i)
        {
            bool reachable = DFS(adj,adj[source][i],destination,visited);
            if(reachable)
                return true;
        }
        
        return false;
    }
    
    
    vector<bool> checkIfPrerequisite(int n, vector<vector<int>>& prerequisites, vector<vector<int>>& queries)
    {
       
        vector<int> adj[n];
        for(int i=0;i<prerequisites.size();++i)
        {
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        
        vector<bool> ret;
        for(int i=0;i<queries.size();++i)
        {
          vector<bool> visited(n,false);
           ret.push_back(DFS(adj,queries[i][0],queries[i][1],visited));
        }
        
        return ret;
        
    }
};
