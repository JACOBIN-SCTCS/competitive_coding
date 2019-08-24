/*
 
   https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/monk-and-power-of-time/

 */

#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int main()
{
	int n,i;
	int ele;
	queue<int> q;
	int cost =0;
	vector<int> ideal;

	cin>>n;
	for(i=0;i<n;++i)
	{
		cin>>ele;
		q.push(ele);
		
	}
	for(i=0;i<n;++i)
	{
		cin>>ele;
		ideal.push_back(ele);
	}

	i=0;
	while(i!=n)
	{
		if(q.front() != ideal[i] )
		{
			ele = q.front();
			q.pop();
			q.push(ele);
			cost=cost+1;
		}
		else
		{
			q.pop();
			i+=1;
			cost+=1;
		}
	}

	cout<<cost<<endl;
	return 0;
}
