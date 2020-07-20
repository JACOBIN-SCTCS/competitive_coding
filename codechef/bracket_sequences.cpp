#include<bits/stdc++.h>

using namespace std;

int main()
{
	string s;
	int j,i;
	int count,paren_count;
	cin>>s;

	i=0;
	count=0;
	while(i!=s.length())
	{
		if(s[i]=='(')
		{
			j=i+1;
			paren_count=1;
			if(j==s.length())
			{
				j=0;
			}
			while(j!=i)
			{
				if(j==s.length())
				{
					j=0;
				}

				if(s[j]=='(')
				{
					paren_count+=1;
				}
				else if(s[j]==')' && paren_count>0)
				{
					paren_count-=1;
				}
				else
				{
					break;
				}
				j+=1;

			}
			if(j==i && paren_count==0)
			{
				count+=1;		
			}

		}
		i+=1;
	}

	cout<<count<<endl;
	



	return 0;
}
