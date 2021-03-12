class Solution {
    
    List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
    
    
    public void DFS(int[][] graph , int source , int n, List<Integer> list)
    {
        if(source==(n-1))
        {
            ret_list.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int adj : graph[source])
        {
            list.add(adj);
            DFS(graph,adj,n,list);
            list.remove(list.size()-1);
        }
        
    }    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        
        DFS(graph,0,graph.length,list);
        return ret_list;
    }
}
