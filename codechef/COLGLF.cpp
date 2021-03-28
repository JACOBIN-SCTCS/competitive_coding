#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t,n,m;
	cin>>t;
	while(t>0)
	{
		cin>>n>>m;
		long  F[n], C[m];
		for(int i=0;i<n;++i)
		{
			cin>>F[i];
		}
		for(int i=0;i<m;++i)
		{
			cin>>C[i];	
		}
		int fptr=0, cptr=0;
		
		int current_channel=0;
		int swap=0;
		while(fptr<n && cptr<m)
		{
			if(F[fptr]<C[cptr])
			{
				if(current_channel!=0)
				{
					swap+=1;
					current_channel=1-current_channel;
				}
				fptr+=1;
			}
			else if (F[fptr]>C[cptr] )
			{
				if(current_channel!=1)
				{
					swap+=1;
					current_channel=1-current_channel;
				}
				cptr+=1;
			}

		}
		if(  (fptr==n && cptr<m && current_channel!=1) || (fptr<n && cptr==m&& current_channel!=0))
		{
			swap+=1;
		}
		cout<<swap<<endl;

		t-=1;
	}
	return 0;
}
