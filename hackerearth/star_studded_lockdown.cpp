#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t,n;
    cin>>t;
    while(t>0)
    {
        string s;
        long sum=0;
        int hashtable[26] = {};
        int i;
        vector<int> count;
        cin>>n;
        cin>>s;

        for(i=0;i<s.length();++i)
        {
            count.push_back(hashtable[s[i]-'a']);
            hashtable[s[i]-'a'] = hashtable[s[i]-'a'] + 1;
        }

        for(i=0;i<count.size();++i )
        {
            sum = sum+count[i];
        }
        cout<<sum<<endl;
        
        t-=1;
    }
    return 0;
}