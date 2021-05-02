#include<bits/stdc++.h>
using  namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int t;
	cin>>t;
	while(t>0)
	{
		string s ;
		int count=0;
		cin>>s;
		for(int i=1;i<s.length();++i)
		{
			if(s[i]!=s[i-1])
			{
				count+=1;
				i+=1;
			}
		}
		cout<<count<<endl;
		t-=1;
	}


	return 0;
}

