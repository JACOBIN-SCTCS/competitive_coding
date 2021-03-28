
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t,k,n;
	cin>>t;
	while(t>0)
	{
		cin>>n>>k;
		if(n%k==0)
		{
			int distance = n/k;
			cout<<distance<<" "<<k<<endl;
		}
		else
		{
			double distance = (double)n/k;
			cout<<ceil(distance)<<" "<<n%k<<endl;
		}
		t-=1;
	}

	return 0;
}
