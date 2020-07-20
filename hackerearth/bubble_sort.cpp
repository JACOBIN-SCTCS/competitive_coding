#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	cin>>n;
	int a[n],i;
	int temp;
	int count=0;

	for(i=0;i<n;++i)
	{
		cin>>a[i];

	}

	bool swapped=true;

	while(swapped!=false)
	{
		swapped=false;
		count+=1;

		for(i=0;i<n-1;++i)
		{
			if(a[i]>a[i+1])
			{
				temp = a[i];
				a[i]=a[i+1];
				a[i+1]=temp;
				swapped=true;
			}
		}
	}
	cout<<count<<endl;



	return 0;
}
