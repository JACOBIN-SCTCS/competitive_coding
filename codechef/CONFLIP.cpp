#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin>>t;
	while(t>0)
	{
		int g;
		cin>>g;
		while(g>0)
		{
			int i,n,q;
			cin>>i>>n>>q;
			if(i==q)
			{
				cout<<n/2<<endl;
			}
			else
			{
				cout<<n-n/2<<endl;
			}
			g-=1;
		}
		t-=1;
	
	}
	
	return 0;
}
