
#include<bits/stdc++.h>

using namespace std;

int main()
{
	int x,y;
	int s;
	int t,y_cord;
	int count=0;

	cin>>x>>y>>s>>t;
	
	for(int i=x;i<=x+s;++i)
	{
		y_cord = t-i;
		if(y_cord >= y && y_cord<= y+s)
		{
			count+= min(max(0,i-x+1),s+1);
		}

	}

	cout<<count<<endl;
	return 0;
}
