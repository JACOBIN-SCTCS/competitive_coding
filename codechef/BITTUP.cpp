#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;

ll mod = 1000000007;

ll exponent(ll a, ll n)
{
	a = a%mod;
	ll res = 1;
	while(n>0)
	{
		if(n&1)
		{
			res = (res * a)%mod;
		}
		a = (a*a)%mod;
		n>>=1;
	}
	return res;
}


int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		ll n,m;
		cin>>n>>m;
		ll first = exponent(2,n)-1;
		cout<<exponent(first,m)<<endl;
		t-=1;
	}
	return 0;
}
