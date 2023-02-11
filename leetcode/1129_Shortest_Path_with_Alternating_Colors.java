
class Node
{
    int color;
    int vertex;

    Node(int color, int vertex)
    {
        this.color = color;
        this.vertex = vertex;
    }
}

class Solution {
    
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) 
    {
        List<List<Node>> adj_list = new ArrayList<List<Node>>();
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Node>());
        
        int[][] distances = new int[2][n];
        Arrays.fill(distances[0],Integer.MAX_VALUE);
        Arrays.fill(distances[1],Integer.MAX_VALUE);


        for(int i=0;i<redEdges.length;++i)
            adj_list.get(redEdges[i][0]).add(new Node(0,redEdges[i][1]));
        for(int i=0;i<blueEdges.length;++i)
            adj_list.get(blueEdges[i][0]).add(new Node(1,blueEdges[i][1]));
        
        Queue<Node> q = new LinkedList<Node>();
        
        distances[0][0] = 0;
        distances[1][0] = 0;

        for(int i=0;i<adj_list.get(0).size();++i)
        {
            Node e = adj_list.get(0).get(i);
            q.add(e);
            distances[e.color][e.vertex] = 1;
        }
        int distance = 1;

        while(!q.isEmpty())
        {
            int len = q.size();
            while(len > 0)
            {
                Node ele = q.poll();
                for(int i=0;i<adj_list.get(ele.vertex).size();++i)
                {
                    Node neighbour = adj_list.get(ele.vertex).get(i);
                    if(ele.color != neighbour.color)
                    {
                        if(distances[neighbour.color][neighbour.vertex] >  distance + 1 )
                        {
                            distances[neighbour.color][neighbour.vertex] = distance+1;
                            q.add(neighbour);
                        }
                    }
                }
                len-=1;
            }
            distance+=1;

        }

        int[] ans = new int[distances[0].length];
        ans[0] = 0;
        for(int i=1;i<ans.length;++i)
        {
            if(distances[0][i]==Integer.MAX_VALUE && distances[1][i]==Integer.MAX_VALUE)
                ans[i] = -1;
            else
            ans[i] = Math.min(distances[0][i],distances[1][i]);
        }
        return ans;

    }
}
