#include<bits/stdc++.h>

using namespace std;
const unsigned int M = 1000000007;


int main()
{

    int t,n;
    long ele;
    cin>>t;
    while(t>0)
    {
        set<long> s;
        cin>>n;
        for(int i=0;i<n;++i)
        {

            cin>>ele;
            s.insert(ele);

        }

        long size = s.size();
        int res=1;
        for(int i=0;i<size-1;++i)
        {
            res = (res*2)%M;
        }
        
        cout<<res<<endl;

        t-=1;
    }
    return 0;
}
