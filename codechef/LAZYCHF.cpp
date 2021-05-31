#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		int x,m,d;
		cin>>x>>m>>d;
		cout<<min(m*x,x+d)<<endl;
		t-=1;
	}
	return 0;
}
