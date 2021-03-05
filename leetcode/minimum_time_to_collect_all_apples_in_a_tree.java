class Solution {
    
    int travelcost=0;
    
    
    public boolean DFS(List<List<Integer>> adj_list, int source, boolean[] visited,List<Boolean> hasApple,int parent)
    {
        
        
        visited[source]=false;
        int ans=0;
        for(int dest : adj_list.get(source))
        {
            if(!visited[dest] && dest!=parent)
            {
                if(DFS(adj_list,dest,visited,hasApple,source))
                {
                    ans+=2;
                }
                
            }
        }
        
        travelcost+=ans;
        
        if(ans==0 && !hasApple.get(source))
            return false;
        return true;
            
        
    }
    
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        for(int i=0;i<n;++i)
        {
            adj_list.add(new ArrayList<Integer>());
            
        }
        
        for(int[] edge : edges)
        {
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(edge[0]);

        }
        
        
        
        
        boolean temp = DFS(adj_list,0,visited,hasApple,-1);
        return travelcost;
        
        
        
    }
}
