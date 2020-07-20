
#include<bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	long n,m,ele;
	long mat[100000][100000];

	cin>>t;
	while(t>0)
	{
		cin>>n>>m;
	
		int max=0,min=100000;

		for(long i=0;i<n;++i )
		{
			for(long j=0;i<m;++j)
			{
				cin>>ele;
				if(ele<min)
				{
					min=ele;
				}
				if(ele>max)
				{
					max=ele;
				}
				mat[i][j]=ele;
			}
		}


		   for(int i=0;i<n;++i )
                {
                        for(int j=0;i<m;++j)
                        {
                               if(mat[i][j]==max || mat[i][j]==min)
			       {
				       mat[i][j]=0;
			       }
			       else
			       {
				       mat[i][j]=1;
			       }
                        }
                }


		int count=0;
		   for(int i=0;i<n;++i )
                {
                        for(int j=0;i<m;++j)
                        {
                                if(mat[i][j]==1)
					count+=1;
                        }
                }


		cout<<count<<endl;
		t-=1;
	}


	return 0;
}
