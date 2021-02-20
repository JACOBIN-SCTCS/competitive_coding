#include<bits/stdc++.h>

using namespace std;

int timer=0;


void aputil(vector<int> graph[],int parent[],bool visited[],
	     bool ap[],int disc[],int low[],int n,int u	
	   )
{
	int numchildren=0;
	disc[u] =low[u] =++timer;
	visited[u]=true;

	for(int i=0;i<graph[u].size();++i)
	{
		if(!visited[graph[u][i]])
		{
			numchildren+=1;
			parent[graph[u][i]]=u;
			aputil(graph,parent,visited,ap,disc,low,n,graph[u][i]);

			if(parent[u]==-1 && numchildren>1)
			{
				ap[u]=true;
			}
			if(parent[u]!=-1 && low[graph[u][i]]>=disc[u])
				ap[u]=true;


		}
		else if(graph[u][i]!=parent[u])
			low[u]=min(low[u],disc[graph[u][i]]);
	}

}



int main()
{

	int n=5;
	vector<int> graph[n];
	
	int parent[n]={-1};
	for(int i=0;i<n;++i)
		parent[i]=-1;
	
	bool  visited[n];
	bool ap[n];
	int disc[n];
	int low[n];
		
	/*
	for(int i=0;i<n;++i)
	{
		if(!visited[i])
		{
			aputil(graph,parent,visited,ap,disc,low,n,i);
		}
	}
	*/

	graph[1].push_back(0);
	graph[0].push_back(1);
	graph[0].push_back(2);
	graph[2].push_back(0);
	graph[1].push_back(2);
	graph[2].push_back(1);
	graph[0].push_back(3);
	graph[3].push_back(0);
	graph[3].push_back(4);
	graph[4].push_back(3);


	for(int i=0;i<n;++i)
	{
		if(!visited[i])
		{
			aputil(graph,parent,visited,ap,disc,low,n,i);
													                
		}
						        
	}



	cout<<"\n\n";
	for(int i=0;i<n;++i)
	{
		if(ap[i])
			cout<<i<<endl;

	}




	return 0;
}

