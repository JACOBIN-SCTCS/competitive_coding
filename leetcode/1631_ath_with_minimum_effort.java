class Element
{
    int x;
    int y;
    int cost;
    
    Element(int x, int y, int cost)
    {
        this.x=x;
        this.y=y;
        this.cost=cost;
    }
}

class ElementComparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1, Element e2)
    {
        return Integer.compare(e1.cost,e2.cost);
    }
    
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        int[][] distance = new int[rows][cols];
        for(int[] row: distance)
            Arrays.fill(row,Integer.MAX_VALUE);
    
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        PriorityQueue<Element> pq = new PriorityQueue<Element>(1,new ElementComparator());
        pq.add(new Element(0,0,0));
        distance[0][0]=0;
        boolean[][] visited = new boolean[rows][cols];
        
        while(!pq.isEmpty())
        {
            Element curr = pq.remove();
            if(curr.x==rows-1 && curr.y == cols-1)
                return distance[curr.x][curr.y];
                
            visited[curr.x][curr.y] = true;
            for(int i=0;i<4;++i)
            {
                int new_x = curr.x + dx[i];
                int new_y = curr.y + dy[i];
                if(new_x<0 || new_x>=rows || new_y<0 || new_y>=cols || visited[new_x][new_y])
                    continue;
                
                int diff = Math.max(distance[curr.x][curr.y], Math.abs(heights[curr.x][curr.y]-heights[new_x][new_y]));
                if(distance[new_x][new_y]>diff)
                {
                    distance[new_x][new_y]= diff;
                    pq.add(new Element(new_x,new_y,diff));
                }
                
            }
        }
        return 0;
        
            
    }
}
