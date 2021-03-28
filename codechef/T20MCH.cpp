#include<bits/stdc++.h>
using namespace std;


int main()
{
	int r,o,c;
	cin>>r>>o>>c;

	if( (c+(20-o)*6*6)>r)
	{
		cout<<"YES";
	}
	else
	{
		cout<<"NO";
	}
	cout<<endl;

	return 0;
}
