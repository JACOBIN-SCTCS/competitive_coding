#include<bits/stdc++.h>

using namespace std;

int main()
{
	long t,n,k;
	string s;
	cin>>t;
	while(t>0)
	{
		cin>>n>>k;
		cin>>s;
		for(int i=0;i<s.length();++i)
		{
			if(s[i]=='a')
				continue;
			
			if((26-(s[i]-'a'))<=k)
			{
				k-=(26-(s[i]-'a'));
				s[i]='a';
			}		
		}
		
		if(k>0)
		{
			char lastchar = s[s.length()-1];
			int offset = lastchar-'a';
			
			offset += k%26;
			offset %=26;

			s[s.length()-1] =  'a'+offset;
		}


		cout<<s<<endl;
		t-=1;
	}
	return 0;
}
