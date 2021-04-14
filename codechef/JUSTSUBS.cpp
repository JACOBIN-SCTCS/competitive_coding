#include<bits/stdc++.h>
using namespace std;

int main()
{
	map<int,int> counts;
	long n,k;
	long ele;
	cin>>n>>k;
	for(int i=0;i<n;++i)
	{
		cin>>ele;
		int rem = ele%k;

		auto itr = counts.find(rem);
		if(itr==counts.end())
		{
			counts.insert({rem,1});
		}			
		else
		{
			itr->second+=1;
		}

	}

	int ele_remaining = 1;
	for(auto itr=counts.begin();itr!=counts.end();++itr)
	{

		if(itr->first!=0)
		{
			if(itr->second%2==1)
				ele_remaining+=1;
		}
	}
	cout<<ele_remaining;

	
	return 0;
}
