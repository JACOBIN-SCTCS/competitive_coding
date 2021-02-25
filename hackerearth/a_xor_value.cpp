#include<bits/stdc++.h>

using namespace std;

int main()
{
	int t,n;
	long value;

	cin>>t;
	while(t>0)
	{	
		cin>>n;
		long a[n];
		int max_bits=0;
		
		for(int i=0;i<n;++i)
		{
			cin>>a[i];
			int n_bits = (log(a[i])/log(2))+1;
			if(max_bits<n_bits)
			{
				max_bits=n_bits;
			}
		}

		value=0;
		int bit=0;
		long exp_2=0;

		for(int i=0;i<max_bits;++i)
		{

			int count_1=0,count_0=0;
			for(int j=0;j<n;++j)
			{
				if(a[j]%2==0)
					count_0+=1;
				else
					count_1+=1;
				a[j]>>=1;
			}
			if(count_1>count_0)
				bit=1;
			else
				bit=0;

			
			//cout<<bit;
			if(i==0)
			{
				exp_2=1;
				value=bit;	
			}
			else
			{
				exp_2=exp_2*2;
				value=value + (bit*exp_2);
			}
		
		}
		cout<<value<<endl;
		t-=1;
	}
	return 0;
}
