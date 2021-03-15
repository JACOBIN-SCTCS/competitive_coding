#include<bits/stdc++.h>

using namespace std;




int main()
{
	//string s="I DO NOT LIKE SEVENTY SEV BUT SEVENTY SEVENTY SEVEN\0",p="SEVENTY SEVEN\0";
	//cin>>s>>p;

	string s="ACABAABABDABABA\0",p="ABABA\0";

	int b[p.length()];
	int i=0,j=-1;
	b[0]=-1;

	while(i<p.length())
	{
		while(j>=0 && p[i]!=p[j])
		       	j=b[j];
		i+=1;
		j+=1;
		b[i]=j;
	}

	for(int i=0;i<p.length();++i)
	{
		cout<<b[i]<<" ";
	}
	
	cout<<endl;
	i=0,j=0;
	while(i<s.length())
	{
		while(j>=0 && s[i]!=p[j]) 
			j=b[j];
		i+=1;
		j+=1;

		if(j==p.length())
		{
			cout<<"Pattern found at"<<(i-j)<<":"<<i<<endl;
			j=b[j];

		}
	}

	return 0;
}

