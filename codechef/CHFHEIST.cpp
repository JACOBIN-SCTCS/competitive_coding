
#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		ll  D,d,P,Q;
		cin>>D>>d>>P>>Q;

		ll  n = D/d;
		ll rem = D%d;
		ll sum = 0 ;

		sum = d*( ( (n*(2*P+(n-1)*Q))/2)  );
		sum =  sum + rem*(P + (n)*Q);
		cout<<sum<<endl;

		t-=1;
	}
	return 0;
}
