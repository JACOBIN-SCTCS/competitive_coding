class Node
{
    public:
        int val;
        bool visited;
        int dfs_num;
        int dfs_low;
        int parent;
    
};





class Solution
{
    vector<vector<int>> ret;
    int timer=0;
public:
    
    void APDFS(vector<int> graph[],Node nodes[],int s)
    {
        nodes[s].visited=true;
        int numchildren=0;
        nodes[s].dfs_num=nodes[s].dfs_low = ++timer;
        for(int i=0;i<graph[s].size();++i)
        {
            if(!nodes[graph[s][i]].visited)
            {
                ++numchildren;
                nodes[graph[s][i]].parent=s;
                APDFS(graph,nodes,graph[s][i]);
                
                if(nodes[graph[s][i]].dfs_low>nodes[s].dfs_num)
                {
                    vector<int> bridge ;
                    bridge.push_back(s);
                    bridge.push_back(graph[s][i]);
                    
                    ret.push_back(bridge);
                    
                   
                    
                }
                
                nodes[s].dfs_low=min(nodes[s].dfs_low,nodes[graph[s][i]].dfs_low);

                
              
            }
            else if(graph[s][i]!=nodes[s].parent)
            {
                nodes[s].dfs_low=min(nodes[s].dfs_low,nodes[graph[s][i]].dfs_num);
            }
       
            
         
            
        }
    }
    
    
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections)
    {
        Node nodes[n];
        for(int i=0;i<n;++i)
        {
            nodes[i].val=i;
            nodes[i].visited=false;
            nodes[i].dfs_num=0;
            nodes[i].dfs_low=0;
            nodes[i].parent=-1;
          
        }
        
        vector<int>graph[n];
        for(int i=0;i<connections.size();++i)
        {
            graph[connections[i][0]].push_back(connections[i][1]);
            graph[connections[i][1]].push_back(connections[i][0]);

        }
        
        for(int i=0;i<n;++i)
        {
            if(!nodes[i].visited)
            {
                APDFS(graph,nodes,i);
            }
        }
        
        return ret;
        
    }
};
