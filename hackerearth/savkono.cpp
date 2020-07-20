#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t;
	long n;
	long count;
	int ele;
	long z;
	
	cin>>t;


	while(t>0)
	{	
		cin>>n;
		cin>>z;
		count=0;
		priority_queue<int> q;
		for(int i=0;i<n;++i)
		{
			cin>>ele;
			q.push(ele);
		}
		
		
		while(!q.empty() &&  z>0 )
		{
			ele = q.top();
			q.pop();
			z-=ele;
			count+=1;
			if((int)(ele/2)!=0)
            {
                q.push(ele/2);
            }
		}
		if(z>0)
		{
			cout<<"Evacuate"<<endl;
		}
		else
		{
			cout<<count<<endl;
		}
		
		
		t-=1;
	}
	return 0;
}
