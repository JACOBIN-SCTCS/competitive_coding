/*
 
    DIP:

    	Store the maximum coins collected so far in an array 
	Check if the coins in the current path + 2 steps behind(alternate monster) is greater than the other path chosen accumulate maximum at a time


	Maximum at each point is chosen from each path
	
 */




#include<bits/stdc++.h>
using namespace std;


int main()
{
	int t,n,i;
	int cases=1;
	long long monsters[10000];
	long long dp[10000];


	cin>>t;
	while(t>0)
	{
	
		cin>>n;
		for(i=0;i<n;++i)
		{
			cin>>monsters[i];

		}
		dp[0]=monsters[0];
		dp[1]=max(monsters[1],dp[0]);
		for(i=2;i<n;++i)
		{
			dp[i]=max(dp[i-2]+monsters[i], dp[i-1]);
		}
		cout<<"Case "<<cases<<": "<<dp[n-1]<<endl;
		cases+=1;
		t--;
	}
	return 0;
}
