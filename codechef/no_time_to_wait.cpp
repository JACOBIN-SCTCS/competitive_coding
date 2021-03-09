#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n,h,x;
	cin>>n>>h>>x;
	int t;
	
	for(int i=0;i<n;++i)
	{
		cin>>t;
		if((x+t)>=h)
		{
			cout<<"YES";
			return 0;
		}
	}

	cout<<"NO";
	return 0;
}
