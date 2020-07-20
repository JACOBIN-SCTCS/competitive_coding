#include<bits/stdc++.h>

using namespace std;

int main()
{
    int n,m,i;
    int start,end,head_node;
    cin>>n>>m;

    vector<int> adj[n+1];
    bool visited[n+1] ={};
    for(int i=0;i<m;++i)
    {
        cin>>start>>end;
        adj[start].push_back(end);
        adj[end].push_back(start);
    
    }
    cin>>head_node;
    visited[head_node]=true;
    stack<int> st;
    
    st.push(head_node);
    while(!st.empty())
    {
        start = st.top();
        st.pop();
        for(i=0;i<adj[start].size();++i)
        {
            if(!visited[adj[start][i]])
            {
                visited[ adj[start][i] ] =1;
                st.push( adj[start][i]);
            }
        }

    }

    long count =0;
    for(i=1;i<n+1;++i)
    {
        if(!visited[i])
        {
            count+=1;
        }
    }
    cout<<count<<endl;

    return 0;
}