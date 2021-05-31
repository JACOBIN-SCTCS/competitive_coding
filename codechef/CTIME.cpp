#include<bits/stdc++.h>
typedef long long int ll;
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		ll n,k,f;
		cin>>n>>k>>f;
		vector<vector<ll>> intervals;
		for(ll i=0;i<n;++i)
		{
			ll first,second;
			cin>>first>>second;
			vector<ll> interval;
			interval.push_back(first);
			interval.push_back(second);
			intervals.push_back(interval);
		}
		sort(intervals.begin(),intervals.end());
		vector<vector<ll>> merge;
		for(auto interval:intervals)
		{
			if(merge.empty() || merge.back()[1]< interval[0])
			{
				merge.push_back(interval);
			}
			else
			{
				merge.back()[1] = max(merge.back()[1],interval[1]);
			}
		}
		ll sum=0;
		for(auto interval:merge)
		{
			//cout<<interval[0]<<"-"<<interval[1]<<endl;
			sum += (interval[1]-interval[0]);
		}
		if((f-sum)>=k)
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;
		t-=1;
	}
	return 0;
}

