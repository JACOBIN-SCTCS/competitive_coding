#include<bits/stdc++.h>
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t;
	cin>>t;
	while(t>0)
	{
		int n;
		long ele;
		cin>>n;
		long prev;
		vector<int> dp;
		int result=0;
		for(int i=0;i<n;++i)
		{
			cin>>ele;
			if(i==0)
			{
				dp.push_back(1);
			}
			else
			{
				if(prev<=ele)
				{
					dp.push_back(1+dp[i-1]);
				}
				else
				{
					dp.push_back(1);
				}
				
			
			}
			prev=ele;
			result+=dp[i];
		}
			
		cout<<result<<endl;

		t-=1;
	}
	return 0;
}
