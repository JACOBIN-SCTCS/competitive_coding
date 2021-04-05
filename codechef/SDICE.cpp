#include<bits/stdc++.h>

typedef long long  ll;
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		ll  n;
		cin>>n;
		
		ll sum=0;
		sum = (n/4)*44;
		ll rem = n%4;
		if(n>=4)
		{
			if(rem==0)
				sum=sum+16;
			else if(rem==1)
				sum = sum + 32;
			else if(rem==2)
				sum = sum + 44;
			else
				sum = sum + 55;
		}
		else
		{
			if(rem==1)
				sum =  20;
			else if(rem==2)
				sum=36;
			else if(rem==3)
				sum = 51;

		}
		

		cout<<sum<<endl;


		t-=1;
	}

	return 0;
}
