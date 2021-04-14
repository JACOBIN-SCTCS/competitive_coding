#include<bits/stdc++.h>
using namespace std;





bool DFS(vector<vector<int>> &grid, vector<vector<bool>> &visited, int x, int y, int tx, int ty)
{
	if(visited[x][y]==true)
		return false;



	if(x==tx && y==ty)
	{
		visited[x][y]=true;
		return true;

	}
	int dirx[4] = {1,0,-1,0};
	int diry[4] = {0,1,0,-1};
	visited[x][y]=true;

	bool ans =false;
	for(int i=0;i<4;++i)
	{
		int new_x = x + dirx[i];
		int new_y = y + diry[i];
		if(new_x>=0 && new_x<grid.size() && new_y>=0 && new_y<grid[0].size() && grid[new_x][new_y]==grid[x][y]
				&& (visited[new_x][new_y]==0))
		{
		
			ans = ans ||  DFS(grid,visited,new_x,new_y,tx,ty);
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
		int m,n;
		cin>>m>>n;
		int ele;

		vector<vector<int>>grid(m);
		
		
		for(int i=0;i<m;++i)
		{
			for(int j=0;j<n;++j)
			{
				cin>>ele;
				grid[i].push_back(ele);
			
			}
		}
		
		int x1,x2,y1,y2;
		cin>>x1>>y1;
		cin>>x2>>y2;
		x1-=1 ; x2-=1; y1-=1; y2-=1;
		vector<vector<bool>> visited(m, vector<bool>(n,0));


		if(grid[x1][y1]==0 && grid[x2][y2]==1)
			cout<<1<<endl;
		else if(grid[x1][y1]==1 && grid[x2][y2]==0)
			cout<<0<<endl;
		else
		{	
		
			bool flag = DFS(grid,visited,x1,y1,x2,y2);
			if(flag==true)
			{	
				if(grid[x1][y1]==0)
					cout<<0<<endl;
				else
					cout<<1<<endl;
			}
			else
			{
				if(grid[x1][y1]==0)
					cout<<1<<endl;
				else
					cout<<0<<endl;
			}
		}

		t-=1;
	}

	return 0;
}

