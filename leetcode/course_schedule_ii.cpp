class Solution {
public:
    
    vector<int> retlist;
    bool flag=true;
    
    void DFS(vector<int> adj_list[], int source, int visited[])
    {
        visited[source]=1;
        
        for(int i=0;i<adj_list[source].size();++i)
        {
            if(visited[adj_list[source][i]]==1)
            {
                flag=false;
                return;
            }
            
            if(!visited[adj_list[source][i]])
            {
                DFS(adj_list,adj_list[source][i],visited);
            }
            
        }
        visited[source]=2;
        retlist.push_back(source);
        
           
        
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) 
    {
        int visited[numCourses];
        for(int i=0;i<numCourses;++i)
            visited[i]=0;
        
        
        vector<int> adj_list[numCourses];
        
        for(int i=0;i<prerequisites.size();++i)
        {
            adj_list[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;++i)
        {
            if(visited[i]==0)
            {
                DFS(adj_list,i,visited);
            }
            if(flag==false)
            {
                vector<int> emp;
                return emp;
                
            }
            
        }
        
        reverse(retlist.begin(),retlist.end());
        return retlist;
    }
};
