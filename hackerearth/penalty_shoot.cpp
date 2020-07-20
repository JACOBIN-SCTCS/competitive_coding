#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	int n,a_count,b_count,a,b,flag;
	string s;
	cin>>t;
	while(t>0)
	{
		
		cin>>n;
		cin>>s;
		
		a_count=b_count=0;
		flag=0;
		a=b=0;
		
		for(int i=0;i<2*n;i++)
		{
			if(i%2==0)
			{
				a_count+=1;
				if(s[i]=='1')
				{
					a+=1;
				}
			}
			else
			{
				b_count+=1;
				if(s[i]=='1')
				{
					b+=1;
				}
			}
			
			if(a-b > n-b_count)
			{
				cout<<i+1<<endl;
				flag=1;
				break;

			}

			if(b-a > n-a_count)
			{
				cout<<i+1<<endl;
				flag=1;
				break;
			}
			
		}

		if(flag==0)
		{
			cout<<2*n<<endl;
		}
		t-=1;
	}
	return 0;
}
