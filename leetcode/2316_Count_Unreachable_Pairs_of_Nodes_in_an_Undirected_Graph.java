class Solution {
    
    public int BFS(List<List<Integer>> adj_list, int source , boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);
        visited[source] = true;
        int count = 1;
        
        while(!q.isEmpty())
        {
            int current = q.remove();
            for(int j=0;j<adj_list.get(current).size();++j)
            {
                int neighbour = adj_list.get(current).get(j);
                if(visited[neighbour]==false)
                {
                    visited[neighbour] = true;
                    count+=1;
                    q.add(neighbour);
                }
            }

        }

        return count;
    }
    
    
    public long countPairs(int n, int[][] edges) 
    {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());
        
        for(int i=0;i<edges.length;++i)
        {
            adj_list.get(edges[i][0]).add(edges[i][1]);
            adj_list.get(edges[i][1]).add(edges[i][0]);

        }
        long remaining = n;
        long ans = 0;
        for(int i=0;i<n;++i)
        {
            if(visited[i]==false)
            {
                int component_size = BFS(adj_list,i,visited);
                ans = ans + component_size*(remaining - component_size);
                remaining  = remaining - component_size;
            }
        }
        return ans;
    }
}
