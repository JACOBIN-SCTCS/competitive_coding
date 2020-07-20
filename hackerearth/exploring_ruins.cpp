#include<bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	cin>>s;

	for(int i=0;i<s.length();++i)
	{
	
		if(s[i]=='?')
		{
			if(i-1>=0 && s[i-1]=='a')
			{
				s[i]='b';
			}
			else 
			{
				if(i+1<s.length() && s[i+1]=='a')
				{
					s[i]='b';
				}
				else
				{
					s[i]='a';
				}
			}
		}
	}
	cout<<s<<endl;

	return 0;
}
