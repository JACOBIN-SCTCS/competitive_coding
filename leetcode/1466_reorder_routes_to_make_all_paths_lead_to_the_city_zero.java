class Edge
{
    int dest;
    boolean forward;
    
    Edge(int dest,boolean forward)
    {
        this.dest = dest;
        this.forward = forward;
    }
}

class Solution {
    
    
    int edges_reversed = 0;
    
    public void DFS(List<List<Edge>> adj_list,int source, boolean[] visited)
    {
        visited[source]=true;
        for(int i=0;i<adj_list.get(source).size();++i)
        {
            if(!visited[adj_list.get(source).get(i).dest])
            {
                if(adj_list.get(source).get(i).forward)
                    edges_reversed+=1;
                DFS(adj_list,adj_list.get(source).get(i).dest,visited);
            }
        }
    }
    
    public int minReorder(int n, int[][] connections) 
    {
        List<List<Edge>> adj_list = new ArrayList<List<Edge>>();
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Edge>());
        
        for(int[] edge:connections)
        {
            adj_list.get(edge[0]).add(new Edge(edge[1],true));
            adj_list.get(edge[1]).add(new Edge(edge[0],false));
        }
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        
        DFS(adj_list,0,visited);
        
        return edges_reversed;
        
        
    }
}
