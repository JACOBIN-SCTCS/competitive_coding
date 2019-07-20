/*
 	Divisors always occur in pairs 

	10 = 5*2 
	ie if p = x*y
	then x and p/x are divisors
	we calculate upto square root of numbers
 */

#include<bits/stdc++.h>


using namespace std;

int main()
{
	int t;
	cin>>t;
	long long num,sum,sqr;
	    
	int i;
	while(t>0)
	{
		cin>>num;
		sqr= sqrt(num);
		sum=0;

		if(num==1)
			cout<<"0";
		else
		{
			for(i=1;i<=sqr;++i)
			{
				if(i==1)
				{
					sum+=1;
				}				
				else if((num%i)==0)
				{
					if(num/i==i)
					{
						sum+=i;
					}
					else
					{
						sum+=i+num/i;
					}
				}
			}
			cout<<sum;
		}
		t--;
	}

	return 0;
}
