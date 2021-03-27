
#include<bits/stdc++.h>
using namespace std;

int  DFS(vector<int> adj[] , int source, bool visited[])
{
    visited[source] = true;
    int ans=1;
    for(int i=0;i<adj[source].size();++i)
    {
        if(visited[adj[source][i]]==false)
        {
           ans+=DFS(adj,adj[source][i],visited);
        }
    }
    return ans;
}



int main()
{   
    int t;
    cin>>t;
    while(t>0)
    {
        int n,m,l,r;
        cin>>n>>m;
        vector<int> adj[n+1];
        vector<int> component_size;

        bool visited[n+1]={false};
        

        for(int i=0;i<m;++i)
        {
            cin>>l>>r;

            if( find(adj[l].begin(),adj[l].end(),r)==adj[l].end() )
            {    
                adj[l].push_back(r);
                adj[r].push_back(l);
            }
        }
    

        for(int i=1;i<=n;++i)
        {
            if(visited[i]==false)
            {
                int size = DFS(adj,i,visited);
                component_size.push_back(size);
            }
        }
        
        long long int result = 0;
        for(int i=0;i<component_size.size();++i)
        {
            for(int j=0;j<component_size.size();++j)
            {
                if(j!=i)
                {
                    result+= component_size[i]*component_size[j];
                }
            }
        }
        cout<<result<<endl;
        t-=1;
    }
    return 0;
}
