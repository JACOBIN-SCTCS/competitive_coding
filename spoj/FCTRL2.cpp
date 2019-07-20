/*
 *	We use an array to store the  number
 *	Each index has the correspinding digit
 *	562 
 *	a[0] =5 a[1]=6 a[2]=2
 *	To find 562 * a number say 56
 *	we iterate through the array 
 *
 *	a[i]= (a[i]*number +temp)%10
 *	temp= temp/10
 *	where temp is first initialized to 0
 *	If temp is not zero
 *	a[incremnt_index] = temp %10
 *	increment index
 */

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

vector<int> numarray;

void fillarray(int num)
{
	int t=num;
	numarray.clear();
	while(t>0)
	{
		numarray.push_back(t%10);
		t=t/10;
	}
}

int main()
{
	
	int t,num;
	int temp,x;
	int i,m;
	cin>>t;


	while(t>0)
	{	
		cin>>num;
		fillarray(num);
		num-=1;
		while(num >= 2)
		{	
			temp=0;
			for(i=0;i<numarray.size();++i)
			{
				x=numarray[i]*num +temp;
				numarray[i]=x%10;
				temp =x/10;	
				
			}
			while(temp!=0)
			{
				numarray.push_back((temp%10));
				temp=temp/10;
				

			}

			num=num-1;
		}
		for(i=numarray.size()-1;i>=0;--i)
		{
			cout<<numarray[i];
		}
		cout<<endl;
		t--;
	}
	return 0;
}

