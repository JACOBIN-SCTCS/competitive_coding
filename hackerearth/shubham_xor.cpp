#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    long long ele,count=0;
    map<long long ,int > m;

    cin>>n;
    for(int i=0;i<n;++i)
    {
        cin>>ele;
        if(m.find(ele) == m.end())
        {
            m.insert(make_pair(ele,1));
        }
        else
        {
            m[ele]+=1;
        }
    }

    count=0;
    for(auto itr = m.begin();itr!=m.end(); ++itr)
    {
        if(itr->second>1)
        {
            count+= (int)((itr->second)*(itr->second-1))/2;
        }
    }
    cout<<count<<endl;
    
    return 0;
}
