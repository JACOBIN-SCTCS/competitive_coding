
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin>>n;
	long smell[n];

	int prefix[n]={0};
	int suffix[n]={0};
	int max_size = 0;

	for(int i=0;i<n;++i)
	{
		long ele;
		cin>>ele;;
		smell[i]=ele;
	}

	prefix[0]=1;
	for(int i=1;i<n;++i)
	{
		if(smell[i]> smell[i-1])
			prefix[i]= 1+ prefix[i-1];
		else
			prefix[i] = 1;

		max_size = max(max_size,prefix[i]);

	}

	suffix[n-1] = 1;
	for(int i=n-2;i>=0;i--)
	{
		if(smell[i]<smell[i+1])
			suffix[i] = 1+ suffix[i+1];
		else
			suffix[i]=1;

		max_size = max(max_size,suffix[i]);
	}

	for(int i=1;i<n-1;++i)
	{
		if(smell[i-1]<smell[i+1])
			max_size = max(max_size,prefix[i-1]+suffix[i+1]);
	}
	cout<<max_size<<endl;

	return 0;
}
