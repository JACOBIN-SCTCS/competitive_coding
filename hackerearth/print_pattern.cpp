#include<bits/stdc++.h>

using namespace std;

int main()
{
    int r,c,i,j;
    int ci,cj;
    cin>>r>>c>>ci>>cj;

    pair<int,int> front_element;
    int d[3]={-1,0,1};
    
    int pattern[r][c] = {};
    bool visited[r][c] ={};

  
    queue<pair<int,int>> q;
    

    q.push(make_pair(ci,cj));
    visited[ci][cj] = 1;
    
    while (!q.empty())
    {
        front_element = q.front();
        q.pop();
        for(i=0;i<3;++i)
        {
            for(j=0;j<3;++j)
            {
                if(front_element.first+d[i]>=0 &&front_element.first + d[i]<r &&front_element.second +d[j] >=0 && front_element.second +d[j]<c && !visited[front_element.first+d[i]][front_element.second+d[j]] )
                {
                    pattern[front_element.first+d[i]][front_element.second+d[j]] = pattern[front_element.first][front_element.second]+1;
                    visited[front_element.first+d[i]][front_element.second+d[j]] = 1;
                    q.push(make_pair(front_element.first+d[i],front_element.second+d[j]));
                }
            }
        }

    }
    
    for(i=0;i<r;++i)
    {
        cout<<endl;
        for(j=0;j<c;++j)
        {
            cout<<pattern[i][j]<<" ";
        }
    }

    return 0;
}