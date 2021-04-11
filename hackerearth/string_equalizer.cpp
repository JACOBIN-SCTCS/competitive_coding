#include<bits/stdc++.h>
using namespace std;

int main()
{
	string a,b;
	int n;
	cin>>n>>a>>b;
	int count=0;
	

	for(int i=0;i<n;++i)
	{
		if(a[i]!=b[i])
		{
			if(i<n-1 && a[i]==b[i+1] && b[i]==a[i+1])
				i+=1; 
			count+=1;
		}

	}
	cout<<count<<endl;
	return 0;

}
