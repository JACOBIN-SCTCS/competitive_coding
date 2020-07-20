#include<bits/stdc++.h>

using namespace std;

int main()
{
    long n;
    long ele;
    long max=0;
    long  sum=0;
    long  ele_count=0;

   

    cin>>n;
    int flag=0;
    max =0;
    for( long i=0;i<n;++i)
    {
        cin>>ele;
        if(ele>=0)
        {
          flag=1;
          sum = sum + ele;
         ele_count+=1; 
        }
        if(max<ele)
        {
            max=ele;
        }
        
       
    }
    if(flag==0)
    {
        cout<<max<<" "<<1;
    }
    else
    {
    cout<<sum<<" "<<ele_count;
    }
    return 0;
}