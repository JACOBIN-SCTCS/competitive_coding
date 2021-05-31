#include<bits/stdc++.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		int n,m,k;
		cin>>n>>m>>k;
		bool attempted[n+1];
		bool disqualified[n+1];
		for(int i=1;i<=n;++i)
		{	
			attempted[i]=false;
			disqualified[i]=false;
		}
		int person;
		int count=0;
		for(int i=0;i<k;++i)
		{
			cin>>person;
			if(person>=(n+1))
				continue;
			if(attempted[person])
			{
				if(disqualified[person]==false)
					count+=1;
				disqualified[person]=true;
			}
			else
				attempted[person]=true;
		}
		cout<<count<<" ";
		for(int i=1;i<=n;++i)
		{
			if(disqualified[i])
				cout<<i<<" ";

		}
		cout<<endl;
		t-=1;
	}
	return 0;
}
