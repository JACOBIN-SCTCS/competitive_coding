#include<bits/stdc++.h>
using  namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int t;
	cin>>t;
	while(t>0)
	{
		int n;
		cin>>n;
		int current,prev, result=0;
		for(int i=0;i<n;++i)
		{
			cin>>current;
			if(i==0)
			{	
				prev = current;
				result+=1;
			}
			else
			{
				if(current<=prev)
				{
					result+=1;
					prev=current;
				}
			
			}
		}
		cout<<result<<endl;
		t-=1;
	}

	return 0;
}
