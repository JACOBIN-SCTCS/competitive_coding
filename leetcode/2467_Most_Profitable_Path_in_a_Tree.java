class Solution {
    
    // Had to refer editorial. Question specified path -> vertices once visited
    // not visited again.

    List<List<Integer>> graph;
    HashMap<Integer,Integer> bobPath;
    int[] bobvisited;

    public boolean getBobPath(int source, int time)
    {
        bobPath.put(source,time);
        bobvisited[source] = 1;

        if(source == 0)
            return true;

        for(int i=0 ; i < graph.get(source).size(); ++i)
        {
            int dest_node = graph.get(source).get(i);
            if(bobvisited[dest_node]!=1)
            {
                boolean res = getBobPath(dest_node,time+1);
                if(res == true)
                    return true;
            }
        }
        bobPath.remove(source);
        return false;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) 
    {
        int n = amount.length;
        graph = new ArrayList<List<Integer>>();
        bobPath = new HashMap<Integer,Integer>();
        bobvisited = new int[n];

        for(int i=0; i < n ; ++i)
        {
            graph.add(new ArrayList<Integer>());
        }  
      
        for(int i=0; i < edges.length; ++i)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        getBobPath(bob,0);

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0,0,0});
        int[] visited = new int[n];
        int res = Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int income = node[2];
            if(!bobPath.containsKey(node[0]) || node[1] < bobPath.get(node[0]))
                income += amount[node[0]];
            else if(node[1] == bobPath.get(node[0]))
                income += (amount[node[0]] / 2);

            if(graph.get(node[0]).size() == 1 && node[0] != 0) 
                res = Math.max(res,income);
            visited[node[0]] = 1;
            for(int i=0 ; i < graph.get(node[0]).size() ; ++i)
            {
                if(!(visited[graph.get(node[0]).get(i)] == 1))
                    q.add(new int[]{graph.get(node[0]).get(i), node[1] + 1 , income});
            }

        }
        return res;
    }
}
