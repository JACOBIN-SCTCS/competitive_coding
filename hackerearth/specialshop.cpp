
#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    long  f,c;
    long floor_cost,ceil_cost;
    float n,a,b;
    cin>>t;
    while(t>0)
    {
        cin>>n>>a>>b;
    
        f = floor((b*n)/(a+b));
        c = ceil((b*n)/(a+b));
        
        
        floor_cost = (a*f*f)+(b*(n-f)*(n-f));
        ceil_cost = (a*c*c)+(b*(n-c)*(n-c));

        cout<<min(floor_cost,ceil_cost)<<endl;

        t-=1;
    }
    return 0;
}