
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t,n,m;
	cin>>t;
	while(t>0)
	{
		cin>>n>>m;
		bool preference[m+1]={false};
		int topic;
		int count=0;

		for(int i=0;i<n;++i)
		{
			cin>>topic;
			if(preference[topic]==false)
			{
				preference[topic]=true;
				count+=1;
			}
		}

		if(count<m)
		{
			cout<<"YES"<<endl;
		}
		else
		{
			cout<<"NO"<<endl;
		}
		t-=1;
	}
	return 0;
}
