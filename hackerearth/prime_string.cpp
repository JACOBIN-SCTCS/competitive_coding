#include<bits/stdc++.h>

using namespace std;
const int limit = 100001;

int main()
{
    
    bool prime[limit];
    int i,j;
    int t;
    for(i=0;i<limit;++i)
    {
        prime[i]=true;
    }

    prime[0]=prime[1]=false;

    for(i=2;i<limit;++i)
    {
        if(prime[i])
        {
            for(j=2*i;j<limit;j=j+i)
            {
                prime[j]=0;
            }
        }
    }

  
    cin>>t;
    while(t>0)
    {
        string s ;
        int a[26] = {};
        bool flag =1;
        int count;
        cin>>s;

        for(i=0;i<s.length();++i)
        {
            a[s[i]-'a'] +=1;
        }
        
        flag=1;
        count=0;
        for(i=0;i<26;++i)
        {
            if(a[i]>0)
            {
                if (!prime[a[i]])
                {
                    flag=0;
                }
                count+=1;
            }
        }

        if(flag==1 && prime[count])
        {
            cout<<"YES"<<endl;
        }
        else
        {
            cout<<"NO"<<endl;
        }
        
        t-=1;
    }

    


    
    return 0;
}