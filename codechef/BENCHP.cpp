#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t-->0)
	{
		int n,w,wr,ele;
		vector<int> arr;
		cin>>n>>w>>wr;
		for(int i=0;i<n;++i)
		{
			cin>>ele;
			arr.push_back(ele);

		}
		if(wr>=w)
		{
			cout<<"YES"<<endl;
			continue;
		}
		int weight_remaining = w-wr;
		int cal_weight=0;
		map<int,int> count_map;
		for(int i=0;i<n;++i)
		{
			ele = arr[i];
			auto itr = count_map.find(ele);
			if(itr==count_map.end())
			{	
				count_map.insert({ele,1});
			}
			else
			{
				itr->second+=1;
				if(itr->second>0 && itr->second%2==0)
				{
					cal_weight+= 2*ele;
					if(cal_weight>=weight_remaining)
						break;
				}
			}
		}
	
		if(cal_weight>=weight_remaining)
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;

		
	}
	return 0;
}

