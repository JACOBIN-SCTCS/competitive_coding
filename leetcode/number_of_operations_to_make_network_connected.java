class Solution {
    
    
    public void DFS(List<List<Integer>> adj_list , int source,boolean[] visited )
    {
        
        visited[source]=true;
        for(int neighbour: adj_list.get(source))
        {
            if(!visited[neighbour])
            {
                DFS(adj_list,neighbour,visited);
                
            }
        }
        
        
    }
    
    
    
    
    
    public int makeConnected(int n, int[][] connections)
    {
        
        if(n>(connections.length+1))
        {
            return -1;
        }
        
        List<List<Integer>> adj_list  = new ArrayList<List<Integer>>();
        for(int i=0;i<n;++i)
        {
            adj_list.add(new ArrayList<Integer>());
        }
        
        for(int [] connection : connections)
        {
            adj_list.get(connection[0]).add(connection[1]);
            adj_list.get(connection[1]).add(connection[0]);

        }
      
        boolean[] visited = new boolean[n];
        int components=0;
        
        for(int i=0;i<n;++i)
        {
            if(!visited[i])
            {    DFS(adj_list,i,visited);
                 components+=1;
            }
        }
        
        return components-1;
        
        
        
    }
}
