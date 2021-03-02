import java.util.LinkedList;

class Coord
{
    int x;
    int y;
    
    Coord(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
}


class Solution {
    
    public boolean checkValidCoordinate(int x , int y, int m,int n)
    {
       
        
        return ( (x>=0)&&(x<m)&&(y>=0)&&(y<n));
    }

    
    public int[][] highestPeak(int[][] isWater)
    {
        
        int[] dx = new int[]{-1,0,1,0};
        int[]  dy = new int[]{0,1,0,-1};
        
        int m = isWater.length;
        int n = isWater[0].length;
        
        int[][] ans = new int[m][n];
        Queue<Coord> q = new LinkedList<Coord>();
        
        
        for(int i=0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(isWater[i][j]==1)
                { 
                    ans[i][j]=0;
                    q.add(new Coord(i,j));
                }
                else
                {
                    ans[i][j]=-1;
                }
            }
        }
        
        
        while(!q.isEmpty())
        {
            Coord curr = q.poll();
            for(int i=0;i<4;++i)
            {
                if(checkValidCoordinate(curr.x+dx[i],curr.y+dy[i],m,n)&&  ans[curr.x+dx[i]][curr.y+dy[i]]==-1)
                {
                    Coord newcoord = new Coord(curr.x+dx[i],curr.y+dy[i]);
                    ans[curr.x+dx[i]][curr.y+dy[i]] = ans[curr.x][curr.y]+1;
                    q.add(newcoord);
                }
            }
        }
        
        return ans;
        
    }
}
