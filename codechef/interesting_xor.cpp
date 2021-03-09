#include<bits/stdc++.h>

using  namespace std;


int main()
{
	int t;
	cin>>t;
	while(t>0)
	{
		long c;
		cin>>c;
		
		long bits = log2(c)+1;
		bitset<31> num1(0);
		bitset<31> num2(0);
		bitset<31> original(c);
		
		
		int msb_found=1;
		for(int i =bits-1;i>=0;i--)
		{
			if(original[i]==0)
			{
				num1|=(1<<i);
				num2|=(1<<i);
			}
			else
			{
				if(msb_found==1)
				{
					num1|=(1<<i);
					msb_found=0;

				}
				else
				{
					num2|=(1<<i);
				}
			}
			
		}
		cout<<num1.to_ulong()*num2.to_ulong()<<endl;
		
		
		t-=1;
		

	}
	return 0;
}
