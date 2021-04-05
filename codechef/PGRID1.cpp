#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin>>t;

	while(t>0)
	{	
		int n;
		cin>>n;
		long w[n];
		long max_val=LONG_MIN;

		for(int  i=0;i<n;++i)
		{
			cin>>w[i];
			max_val = max(max_val,w[i]);
		}
		
		int num_op = 0;
		int grid[max_val][max_val];

		for(int i=n-1;i>=0;i--)
		{
			for(int j=0;j<w[i];++j)
			{
				int curr_x = i;
				int curr_y = j;
				if(grid[curr_x][curr_y]==0)
				{
					num_op+=1;
					while( curr_x>=0 && curr_y>=0 && w[curr_x]>curr_y && grid[curr_x][curr_y]==0)
					{
						grid[curr_x][curr_y]=1;
						curr_x-=1;
						curr_y-=1;
					}

				}
			}
		}
		cout<<num_op<<endl;
		t-=1;

	}



	return 0;

}
