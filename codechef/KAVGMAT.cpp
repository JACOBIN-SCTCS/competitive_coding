#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{

		int n,m;
		double k;
		cin>>n>>m>>k;
	
		double matrix[n+1][m+1];

		for(int i=0;i<=n;++i)
		{
			for(int j=0;j<=m;++j)
			{
				if(i==0 || j==0)
					matrix[i][j]=(double)0;
				else
					cin>>matrix[i][j];
			}
		}
		
		

		for(int i=1;i<=n;++i)
		{
			//cout<<endl;
			for(int j=1;j<=m;++j)
			{
				matrix[i][j] =  matrix[i-1][j]+matrix[i][j-1] - matrix[i-1][j-1]+matrix[i][j];
				//cout<<matrix[i][j]<<" ";
				
			}
		}

		

		int mini = min(n,m);
		long long int ans=0;
		
		for(int u=1;u<=mini;++u)
		{
			for(long long int i=u;i<=n;++i)
			{
				for(long long int j=u;j<=m;++j)
				{
					double sum = matrix[i][j] - matrix[i-u][j] - matrix[i][j-u] + matrix[i-u][j-u];
					sum = sum/(u*u);
					if(sum>=k)
						ans+=1;
				}
			}
		}


		cout<<ans<<endl;

	

		t-=1;
	}
	return 0;
}
