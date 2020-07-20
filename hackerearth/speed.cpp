#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t,n,ele,count;
    vector<int> speed;
    cin>>t;
    while (t>0)
    {
        cin>>n;
        speed.clear();
        
        for(int i=0;i<n;++i)
        {
            cin>>ele;
            speed.push_back(ele);
        }

        count = 1;
        for(int i=1;i<n;++i)
        {
            if(speed[i]<=speed[i-1])
            {
                count+=1;
            }
            else
            {
                speed[i]=speed[i-1];
            }
        }
        cout<<count<<endl;
        t-=1;
    }
    
}