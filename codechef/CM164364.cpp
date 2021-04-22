#include<bits/stdc++.h>
using namespace std;


void solve()
{
	int n,x;
	long ele;
	cin>>n>>x;
	int distinct_count=0;
	map<long,int> hashmap;
	
	for(int i=0;i<n;++i)
	{
		cin>>ele;
		auto itr = hashmap.find(ele);
		if(itr!=hashmap.end())
			itr->second+=1;
		else
		{
			hashmap.insert({ele,1});
			distinct_count+=1;
		}
	}
	int choco_remaining = n-x;
	cout<<min(choco_remaining,distinct_count)<<endl;



}


int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		solve();
		t--;
	}
	return 0;
}
