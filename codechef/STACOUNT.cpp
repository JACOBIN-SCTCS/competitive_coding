#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n,e,u,v;
	cin>>n>>e;

	vector<int> adj[n];
	for(int i=0;i<e;++i)
	{
		cin>>u>>v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	vector<int> distance(n,INT_MAX);
	queue<int> q;
	q.push(0);
	distance[0]=0;
	int maximum = INT_MIN;
	int stadium=0;
	while(!q.empty())
	{
		int curr = q.front();
		if(maximum<distance[curr])
		{
			maximum = max(maximum,distance[curr]);
			stadium=curr;
		}
		q.pop();
		for(int i=0;i<adj[curr].size();++i)
		{
			if(distance[curr]+1 < distance[adj[curr][i]])
			{
				distance[adj[curr][i]] = distance[curr]+1;
				q.push(adj[curr][i]);
			}

		}
	}

	cout<<stadium<<" "<<maximum<<endl;

	return 0;

}

