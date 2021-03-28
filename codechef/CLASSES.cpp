#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		int n,m,s,k;
		cin>>n>>m>>s>>k;

		vector<int> adj[n+1];
		int subject_taught[n+1]={0};

		int u,v;
		
		for(int i=0;i<m;++i)
		{
			cin>>u>>v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		
		}
		int building;
		for(int i=0;i<s;++i)
		{
			cin>>building;
			subject_taught[building]+=1;
		}

		long travel_time=0;
		queue<int> q;
		bool visited[n+1]={false};
		long distance[n+1]={0};

		distance[0]=0;
		q.push(0);
		visited[0]=true;
			
		while(!q.empty())
		{
			
			int curr = q.front();
			q.pop();
			if(subject_taught[curr]>0)
			{
				
				k =k-subject_taught[curr];
				travel_time += (long) 2*distance[curr];
			}
			if(k<=0)
				break;

			for(int i=0;i<adj[curr].size();++i)
			{
				if(!visited[adj[curr][i]])
				{
					distance[adj[curr][i]] = distance[curr]+1;
					visited[adj[curr][i]]=true;
					q.push(adj[curr][i]);
				}
			}


		}
		cout<<travel_time<<endl;


		t-=1;
	}
	return 0;
}
