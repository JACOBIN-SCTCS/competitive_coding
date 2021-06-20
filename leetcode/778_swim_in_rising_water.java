
class Element
{
    int x;
    int y;
    int time;
    
    Element(int x, int y, int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}


class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] distance = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        for(int[] row:distance)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2)
            {
                return Integer.compare(e1.time,e2.time);
            }
        });
        
        pq.add(new Element(0,0,grid[0][0]));
        distance[0][0] = grid[0][0];
        while(!pq.isEmpty())
        {
            Element curr = pq.poll();
            if(curr.x==(n-1) && curr.y==(n-1))
                return distance[curr.x][curr.y];
            visited[curr.x][curr.y]  = true;
            
            for(int i=0;i<4;++i)
            {
                int new_x = curr.x+dx[i];
                int new_y = curr.y+dy[i];
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<n && !visited[new_x][new_y])
                {
                    int current_distance = Math.max(distance[curr.x][curr.y],grid[new_x][new_y]);
                    if(current_distance<distance[new_x][new_y])
                    {
                        pq.add(new Element(new_x,new_y,current_distance));
                        distance[new_x][new_y] = current_distance;
                    }
                }
            }
        }
        
        return -1;
        
    }
}
