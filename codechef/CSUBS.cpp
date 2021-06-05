#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		int n,k;
		cin>>n>>k;
		int arr[n];
		for(int i=0;i<n;++i)
		{
			cin>>arr[i];
		}


		int ans=0;
		for(int i=0;i<k;++i)
		{
			map<int,int> counts;
			int max_freq=0;
			for(int j=i;j<n;j+=k)
			{
				counts[arr[j]]++;
				max_freq = max(max_freq,counts[arr[j]]);
			}
			ans += max_freq;
		}
		cout<<n-ans<<endl;
		t-=1;
	}
	return 0;
}
