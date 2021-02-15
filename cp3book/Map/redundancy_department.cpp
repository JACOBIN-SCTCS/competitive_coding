#include<bits/stdc++.h>

using namespace std;

int main()
{
	int n;
	map<int,int> dict;
	vector<int> elements;
	elements.clear();

	while(cin>>n)
	{
		
		dict[n]+=1;
		if(dict[n]==1)
			elements.push_back(n);

	}
	
	for(int i=0;i<elements.size();++i)
	{
		cout<<elements[i]<<" "<<dict[elements[i]]<<endl;
	}


	return 0;
}

