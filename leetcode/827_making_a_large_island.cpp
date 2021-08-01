class Solution {
public:
    
    int ans = 1;
    int dfs(vector<vector<int>> &grid, int x, int y, int color)
    {
        if(x<0 || x>=grid.size() || y<0 || y>= grid.size() || grid[x][y]!=1)
            return 0;
        
        
        int ans = 1;
        grid[x][y] = color;
        ans += dfs(grid,x-1,y,color);
        ans += dfs(grid,x+1,y,color);
        ans += dfs(grid,x,y-1,color);
        ans += dfs(grid,x,y+1,color);
        return ans;
    }
    
    int largestIsland(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        int dx[4] = {-1,0,1,0};
        int dy[4] = {0,1,0,-1};
        
        int k=2;
        map<int,int> regions;
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j]==1)
                {
                    int curr_area = dfs(grid,i,j,k);
                    ans = max(ans,curr_area);
                    regions[k] = curr_area;
                    k+=1;
                }    
            }
        }
        
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(grid[i][j] == 0)
                {
                    int current =1;
                    set<int> neighbours;
                    for(int k=0;k<4;++k)
                    {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        if(nx<0 || nx>=n || ny<0 || ny>=n || grid[nx][ny]==0)
                            continue;
                        
                        if(neighbours.find(grid[nx][ny]) == neighbours.end())
                        {
                            current = current + regions[grid[nx][ny]];
                            neighbours.insert(grid[nx][ny]);
                        }
                        
                    }
                    ans = max(ans,current);
                }
            }
        }
        
        return ans;
            
    }
    
    
};
