#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	long n;
	long i;
	long result = 0;
	cin>>t;	
	while(t>0)
	{
		result = 0;
		cin>>n;
		i=5;	
		while((n/i)>=1)
		{
			result += long(n/i);
			i*=5;
		}
		cout<<result<<endl;
		t-=1;
	}

	return 0;
}
