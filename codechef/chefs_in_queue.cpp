#include<bits/stdc++.h>

using namespace std;

int main()
{
	long n,k;
	long seniority;
	stack<pair<long,long>> st;
	vector<long> q;
	long fearfulness = 1;

	cin>>n>>k;

	for(int i=0;i<n;++i)
	{
		cin>>seniority;
		q.push_back(seniority);
	}


	for(int i = q.size()-1;i>=0;i--)
	{
		while(!st.empty() && st.top().first >= q[i] )
			st.pop();
		if(!st.empty())
		{
			fearfulness = (fearfulness*(st.top().second-i+1))%1000000007;
		}
		st.push(make_pair(q[i],i));
	}
	cout<<fearfulness<<endl;
	return 0;
}
