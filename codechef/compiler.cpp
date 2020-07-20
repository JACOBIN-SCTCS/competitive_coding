#include<bits/stdc++.h>

using namespace std;

int main()
{
	int  t;
	int ans;
	int paren_count=0;
	string s;
	int flag=0;
	cin>>t;

	while(t>0)
	{
		cin>>s;
		flag=0;
		ans=0;
        
        paren_count=0;
        for(int i=0;i<s.length();++i)
        {
            if(paren_count==0 && s[i]=='>')
			{
				ans=i;
			
				break;
			}
			else if(s[i]=='<')
			{
				paren_count+=1;
			}
			else
			{
				paren_count-=1;
				if(paren_count==0)
				{
					ans=max(ans,i+1);
				}
				else if(paren_count<0)
				{
					break;
				}
				
			}
			
        }
		
		cout<<ans<<endl;
		t-=1;
	}
	return 0;
}
