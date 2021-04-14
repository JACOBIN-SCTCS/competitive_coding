#include<bits/stdc++.h>

using namespace std;
int main()
{
	int t;
	int n;

	cin>>t;
	while(t>0)
	{
		cin>>n;
		long ele;
		map<long,int> counts;
		for(int i=0;i<n;++i)
		{
			cin>>ele;
			auto itr = counts.find(ele);
			if(itr==counts.end())
			{
				counts.insert(pair<long,int>(ele,1));
			}
			else
			{
				itr->second+=1;
				
			}
			
	
		}

		for(auto itr = counts.begin();itr!=counts.end();itr++)
		{
			if(itr->second==3)
			{
				cout<<(itr->first)*3<<endl;
				break;
			}
		}

		//map<long,int> counts;
		t-=1;
	}
	return 0;
}
