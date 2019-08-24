#include<iostream>
#include<vector>

using namespace std;

int main()
{
	vector<int> count; 
	int n,i,ele;
	int q;

	cin>>n;
	for(i=0;i<n;++i)
	{
		cin>>ele;

		count[ele]+=1;
		
	}
	cin>>q;
	for(i=0;i<q;++i)
	{
		cin>>ele;
		if(count[ele] != 0)
		{
			cout<<count[ele]<<endl;
		}
		else
		{
			cout<<"NOT PRESENT"<<endl;
		}
	}

	return 0;
}
