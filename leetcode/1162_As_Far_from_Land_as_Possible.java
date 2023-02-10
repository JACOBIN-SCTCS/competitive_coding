class Pair
{
    int x;
    int y;

    Pair(int x , int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Solution {


    public int maxDistance(int[][] grid) 
    {
        int[][] distance_value = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<grid.length;++i)
        {
           for(int j=0;j<grid[0].length;++j)
           {
               if(grid[i][j]==1)
               {
                   q.add(new Pair(i,j));
                    distance_value[i][j] = 0;
               }
               else
               {
                   distance_value[i][j] = Integer.MAX_VALUE;
               }       
           }
        }

        int distance = 0;
        int[] xdir = new int[]{0,-1,0,1};
        int[] ydir = new int[]{-1,0,1,0};
        while(!q.isEmpty())
        {
            int length = q.size();
            while(length > 0)
            {
                Pair ele = q.poll();
                for(int i=0;i<4;++i)
                {
                    int new_x = ele.x + xdir[i];
                    int new_y = ele.y + ydir[i];

                    if(new_x < 0  || new_x >= grid.length || new_y <0 || new_y >= grid[0].length)
                        continue;

                    if((distance + 1)  < distance_value[new_x][new_y])
                    {
                        q.add(new Pair(new_x,new_y));
                        distance_value[new_x][new_y] = distance + 1;
                    }
                }
                length-=1;

            }
            if(!(q.isEmpty()))
                distance = distance + 1;
        }

        if(distance == 0)
            return -1;
        else
            return distance;
    }
}
