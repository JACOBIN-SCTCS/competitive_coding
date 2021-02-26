
#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t,n;
    cin>>t;
    while(t>0)
    {
        cin>>n;
        long a[n];
        long b[n];

        for(int i=0;i<n;++i)
        {
            cin>>a[i];
        }

        for(int i=0;i<n;++i)
        {
            cin>>b[i];
        }

        int ans = 0;


        for(int i=0;i<n;++i)
        {
            long ele = a[i];

            int low = 0;
            int high=n-1;
            int mid;
            int pos=-1;

            while(low<=high)
            {
                mid = (low+high)/2;
                if(b[mid]>=a[i])
                {
                    pos=mid;
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
                ans = max(ans,(pos-i));
            }



        }
        cout<<ans<<endl;

        t-=1;
    }
}
