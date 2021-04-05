
#include<bits/stdc++.h>
using namespace std;



int main()
{
	int t;
	double k1,k2,k3,v;
	cin>>t;
	while(t>0)
	{
		cin>>k1>>k2>>k3>>v;
		float speed = k1*k2*k3*v;
		float time = 100/speed;
		float  result = roundf(time*100)/100;
	
		float baseline = 9.58;
	

		if(result<baseline)
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;
		t-=1;
	}
	return 0;
}
