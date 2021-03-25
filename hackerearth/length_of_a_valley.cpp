#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;

    while(t>0)
    {

        int n;
        long ele;
        cin>>n;
        long a[n];
        int low[n];
        int high[n];

        for(int i=0;i<n;++i)
        {
            cin>>ele;
            a[i]=ele;
           
            if(i>0 && a[i]<a[i-1])
                low[i]=low[i-1]+1;
            else
                low[i]=1;
            
        }

        for(int i=n-1;i>=0;i--)
        {
            if(i<n-1 && a[i]<a[i+1])
                high[i] = high[i+1]+1;
            else
                high[i]=1;
        }  
        for(int i=0;i<n;i++)
        {
           cout<<(high[i]+low[i]-1)<<" "; 
        }  
        cout<<endl;
        t-=1;
    }


    return 0;
}
