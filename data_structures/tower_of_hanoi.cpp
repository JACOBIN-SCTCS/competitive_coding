#include<bits/stdc++.h>
using namespace std;

int towerofhanoi(int n , int from_rod, int to_rod, int aux_rod)
{
	if(n==0)
		return 0;
	else
	{
		return ( towerofhanoi(n-1,from_rod,aux_rod,to_rod) +
			1+
			towerofhanoi(n-1,aux_rod,to_rod,from_rod));
	}
}


int main()
{
	int moves = towerofhanoi(3,0,1,2);
	cout<<moves;
	return 0;
}
