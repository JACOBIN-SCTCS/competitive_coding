#include<bits/stdc++.h>
using namespace std;
int main()
{
	//ios::sync_with_stdio(false);
	//cin.tie(0); cout.tie(0);
	int t;
	cin>>t;
	while(t>0)
	{
		int l;
		string s;
		cin>>l;
		cin>>s;

		double count=0;
		int length=0;
		bool flag = false;
		for(int i=0;i<s.size();++i)
		{
			length+=1;
			if(s[i]=='1')
			{
				count+=1;
				double res = (count/length);
				if(res>=0.5)
				{
					cout<<"YES"<<endl;
					flag=true;
					break;
				}
			}
		}
		if(flag==false)
			cout<<"NO"<<endl;
		t-=1;
	}
	return 0;
}
