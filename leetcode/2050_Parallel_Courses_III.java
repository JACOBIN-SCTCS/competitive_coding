class Solution {
    
    List<Integer> topological_ordering;
    
    public void visit(int current_node, List<List<Integer>> edges, int[] visited)
    {
        if(visited[current_node]==2)  
            return;
        
        visited[current_node] = 1;
        List<Integer> neighbours = edges.get(current_node);
        for(int i=0;i<neighbours.size();++i)
        {
            int neighbour = neighbours.get(i);
            visit(neighbour,edges,visited);
        }
        visited[current_node] = 2;
        topological_ordering.add(current_node);
    }

    public int minimumTime(int n, int[][] relations, int[] time) 
    {
        int[] visited = new int[n];
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        int[] t = new int[n];

        for(int i=0;i<n;++i)
            edges.add(new ArrayList<Integer>());

        topological_ordering = new ArrayList<Integer>();

        for(int i=0;i<relations.length;++i)
        {
            int start = (relations[i][0]-1);
            int end = (relations[i][1]-1);
            edges.get(start).add(end);
        }


        for(int i=0;i<n;++i)
        {
            visit(i,edges,visited);
        }
        Collections.reverse(topological_ordering);
        int max_time = 0;
   
        for(int i=0;i<topological_ordering.size();++i)
        {
            int current = topological_ordering.get(i);
            List<Integer> neighbours = edges.get(current);
            max_time = Math.max(max_time,time[current]);
            for(int j=0; j< neighbours.size();++j)
            {
                t[neighbours.get(j)] = Math.max(t[neighbours.get(j)],t[current] + time[current]);
                max_time = Math.max(max_time, t[neighbours.get(j)] + time[neighbours.get(j)]);
            }
        }
        return max_time;

    }
}
