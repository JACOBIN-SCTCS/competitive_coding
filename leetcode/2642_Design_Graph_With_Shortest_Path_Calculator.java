class Graph {

    int num_nodes;
    int[][] adj_graph;

    public Graph(int n, int[][] edges) 
    {
        num_nodes = n;
        adj_graph = new int[n][n];
        for(int i=0;i<n;++i)
        {
            Arrays.fill(adj_graph[i],Integer.MAX_VALUE);
            adj_graph[i][i] = 0;
        }    
        for(int[] e : edges)
        {
            adj_graph[e[0]][e[1]] = e[2];
        }

    }
    
    public void addEdge(int[] edge) {
        adj_graph[edge[0]][edge[1]] = edge[2];
    }   
    
    public int shortestPath(int node1, int node2) 
    {
        int[] distance = new int[num_nodes];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[node1] = 0 ;

 
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(1, new Comparator<Pair<Integer,Integer>>(){

            public int compare(Pair<Integer,Integer> a , Pair<Integer,Integer> b)
            {
                return (a.getValue() - b.getValue());
            }

        });

        pq.add(new Pair(node1,0));

        while(!pq.isEmpty())
        {
            Pair<Integer,Integer> cur_ele = pq.poll();
            if(cur_ele.getKey() == node2)
                return cur_ele.getValue();

            for(int i=0;i<num_nodes;++i)
            {
                if(adj_graph[cur_ele.getKey()][i] != Integer.MAX_VALUE)
                {
                    int new_distance = distance[cur_ele.getKey()] + adj_graph[cur_ele.getKey()][i];
                    if(distance[i] > new_distance)
                    {
                        distance[i] = new_distance;
                        pq.add(new Pair(i,new_distance));
                    }
                }
            }

        }

        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
