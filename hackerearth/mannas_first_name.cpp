
#include<bits/stdc++.h>

using namespace std;

int main()
{
    int t,i;
    string s;

    int suvo,suvojit;

    cin>>t;
    while(t>0)
    {

        cin>>s;
        
        suvo=suvojit=0;
        i=0;

        while(i<s.length())
        {
            if(s[i]=='S')
            {
                if(s.length()-i>=7 && s[i+1]=='U' && s[i+2]=='V' && s[i+3]=='O' && s[i+4]=='J' && s[i+5]=='I' && s[i+6]=='T' )
                {
                    suvojit+=1;
                    
                }
                else if(s.length()-i>=4 && s[i+1]=='U' && s[i+2]=='V' && s[i+3]=='O')
                {
                    suvo+=1;
                
                }
            }
            i+=1;
            
        }
        cout<<"SUVO = "<<suvo<<", SUVOJIT = "<<suvojit<<"\n";
        
        t-=1;
    }

    return 0;
}
