#include<bits/stdc++.h>

using namespace std;

int main()
{
    int n;
    int a,b,ele,inp_level,count;
    int i;

    cin>>n;
    bool visited[n+1]={false};
    visited[0]=true;
    vector<int> adj[n+1];
    int level[n+1]={0};

    for(i=0; i<n-1;++i)
    {
            cin>>a>>b;
            adj[a].push_back(b);
            adj[b].push_back(a);
    }

    cin>>inp_level;
    queue<int> q;
    q.push(1);
    visited[1] = true;
    level[1]=1;

    while (!q.empty())
    {
       ele = q.front();
       q.pop();

     
        for(i=0;i<adj[ele].size();++i)
        {
            if(!visited[adj[ele][i]])
            {   q.push(adj[ele][i]);
               level[adj[ele][i]] = level[ele]+1;
               visited[adj[ele][i]] = 1;
            }  
        }
       
    }

    count = 0;
    
    for(i=1;i<n+1;++i)
    {
        if(level[i] == inp_level)
        {
           count+=1;
        }
    }
    cout<<count<<endl;

    return 0;
}


