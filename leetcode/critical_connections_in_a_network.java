class Node
{
    boolean visited ; 
    int dfs_num ;
    int dfs_low;
    int parent;
    
    
    Node()
    {
        this.visited = false;
        this.dfs_num = 0;
        this.dfs_low = 0;
        this.parent = -1;
    }
    
}


class Solution 
{
    List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
    int timer=0;
    
    public void DFS(List<List<Integer>> adj_list, int source, Node[] nodes)
    {
        nodes[source].visited = true;
        nodes[source].dfs_num = nodes[source].dfs_low = timer++;
        
        for(int neighbour: adj_list.get(source))
        {
            if(nodes[neighbour].visited==false)
            {
                nodes[neighbour].parent = source;
                DFS(adj_list,neighbour,nodes);
                if(nodes[neighbour].dfs_low> nodes[source].dfs_num)
                {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(source);
                    res.add(neighbour);
                    ret_list.add(res);
                }
                nodes[source].dfs_low = Math.min(nodes[source].dfs_low,nodes[neighbour].dfs_low);
            }
            else if(nodes[source].parent != neighbour)
            {
                nodes[source].dfs_low = Math.min(nodes[source].dfs_low,nodes[neighbour].dfs_num);
            }
                
        }
        
        
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
    {
        Node[] nodes = new Node[n];
        for(int i=0;i<n;++i)
            nodes[i] = new Node();
        
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());
        for(List<Integer> edge:connections)
        {
            adj_list.get(edge.get(0)).add(edge.get(1));
            adj_list.get(edge.get(1)).add(edge.get(0));

        }
        
        DFS(adj_list,0,nodes);
        return ret_list;
        
    }
}
