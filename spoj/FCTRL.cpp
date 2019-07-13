#include <iostream>
using namespace std;

int calculate_zeroes(int num)
{
	int zerocount=0;
	
	for(int i=5; num/i >=1 ; i*=5)
	{
		zerocount+=num/i;	
	}
	return zerocount;
}

int main() {
	// your code goes here
	int t;
	int num;
	
	cin>>t;
	while(t>0)
	{
		cin>>num;
		num = calculate_zeroes(num);
		cout<<num<<endl;
		t--;
	}
	return 0;
}
