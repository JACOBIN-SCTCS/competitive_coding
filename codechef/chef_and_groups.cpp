
#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	cin>>t;

	while(t>0)
	{
		string s;
		cin>>s;
		
		int count=0;
		int group=0;

		for(int i=0;i<s.size();++i)
		{
			if(s[i]=='1')
			{
				if(count==0)
				{
					group+=1;
				}
				count+=1;
			}
			else
			{
				count=0;
			}
		}
		cout<<group<<endl;


		t-=1;
	}

	return 0;
}
