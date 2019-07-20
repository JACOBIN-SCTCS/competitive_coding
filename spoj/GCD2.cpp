/*
 *
 * 1234 % 7.
	1 mod 7 = 1
	12 mod 7 = (1 * 10 + 2) mod 7 = 5
	123 mod 7 = (5 * 10 + 3) mod 7 = 4
	1234 mod 7 = (4 * 10 + 4) mod 7 = 2 
 *
 */

#include<bits/stdc++.h>
#include<string.h>
using namespace std; 


int gcd(int a,int b)
{
	if(b==0)
		return a;
	else
		return gcd(b,a%b);
}
int main()
{
	int t;
	string b;
	int a,num=0;
	cin>>t;
	while(t>0)
	{
		cin>>a>>b;
		

		for(int i=0;i<b.length();++i)
		{
			num = (num*10+ (b[i]-'0'))%a;
		}

		num =gcd(a,num);
		cout<<num;
		t--;

	}
	return 0;
}
