/*
 https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/range-query-2/description
 */

#include<iostream>
#include<vector>


using namespace std;

int main()
{
	 
	int n,q,i,bit_pos;
	int query_type , l,r;
	cin>>n>>q;
	vector<int> binary_number(n+1);
	for(i=0;i<n;++i)
	{	
		cin>>bit_pos;
		binary_number[i] = bit_pos;

	}
	for(i=0;i<q;++i)
	{
		cin>>query_type;
		if(query_type==1)
		{
			cin>>l;
			binary_number[l-1] =1-binary_number[l-1];
		}
		else
		{
			cin>>l>>r;
			if(binary_number[r-1] ==1)
			{
				cout<<"ODD"<<endl;

			}
			else
			{
				cout<<"EVEN"<<endl;
			}

		}
	}
		
	return 0;
}


