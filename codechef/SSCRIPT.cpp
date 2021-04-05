#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		int n,k;
		string s;
		bool flag=false;

		cin>>n>>k;
		cin>>s;

		for(int i=0;i<=n-k;++i)
		{
			if(s[i]=='*')
			{
				int count=0;
				for(int j=i;j<i+k;++j)
				{
					if(s[j]=='*')
					{
						count+=1;

					}else
					{
						i=j;
						break;
					
					}
				}
				if(count==k)
				{
					flag=true;
					break;
				}
				
			

			}	
			
		}

		if(flag==true)
			cout<<"YES"<<endl;
		else
			cout<<"NO"<<endl;

		t-=1;
	}


	return 0;
}
