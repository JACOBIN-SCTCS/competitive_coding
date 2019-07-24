/*
	Given sequence F(n)
       	F(n) - F(n-1) = F'(n)
	Derivative usually gives a polynomial having less order
	which can be used to solve . 

	Therefore we find difference between consecutive elements and
	continue process till we are left with constants only in sequence.
	Example : 	1 2 4 7 11 16 22 29
			 1 2 3 4  5  6  7
		 	  1 1 1  1  1  1	
We are left with constants append the same constant equal to the number of extra numbers which we need
		
	Example 3 : 	1 1 1 1 1 1 1 1 1
       		       1 2 3 4 5 6 7 8 9 10
		       1 2 4 7 11 16 22 29 37


	ie A[i][j]= A[i-1][j-1] + A[i][j-1]
*/




#include<iostream>

using namespace std;

int calculate_order(int table[][100],int S)
{
	bool flag = true;
	int i,j, rowabove =S;
	for(i=1;i<S;++i)
	{
		flag=true;  	// New sequence of differences 
		for(j=1;i<rowabove;++j)
		{
		 table[i][j] = table[i-1][j] -table[i-1][j-1];
	       	 if(j!=0 && table[i][j] !=table[i][j-1])  //corner case
			{
				flag=false; //do not exit as constant hasnt reached

			}
 		 		 
		}
		rowabove--;
		if(flag)
			break;

	}
	
	return i;
}



int main()
{
	int t ,i,index;
	int S,C;
	int table[100][100];


	cin>>t;
	while(t>0)
	{
		cin>>S>>C;
		for(i=0;i<S;++i)
		{
			cin>> table[0][i];
		}
		index=calculate_order(table,S);
		cout<<index;
		t--;
	}
	return 0;
}




