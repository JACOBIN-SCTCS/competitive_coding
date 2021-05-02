#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
const int mod = 1000000007;
int main()
{
	int n;
	int x,q;
	ll ele;
	ll sum=0;
	cin>>n;
	for(int i=0;i<n;++i)
	{
		cin>>ele;
		sum+=ele;
	}
	sum%=mod;
	if(sum<0) sum+=mod;
	cin>>q;
	for(int i=0;i<q;++i)
	{
		cin>>x;
		sum+=sum;
		if(sum>=mod)
			sum-=mod;
		cout<<sum<<endl;
	}

	return 0;
}

