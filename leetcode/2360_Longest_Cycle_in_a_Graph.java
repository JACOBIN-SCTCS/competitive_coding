class Solution 
{
    int ans = -1;
    void DFS(int[] edges,  int node, boolean[] visited, HashMap<Integer,Integer> distance)
    {
        visited[node] = true;
        int neighbour = edges[node];

        if(neighbour==-1)
            return;
        if(visited[neighbour]==false)
        {
            distance.put(neighbour,distance.get(node) + 1);
            DFS(edges,neighbour,visited,distance);
        }
        else if(distance.containsKey(neighbour))
        {
            ans = Math.max(ans,distance.get(node) - distance.get(neighbour)+1);
        }

    }    
    
    public int longestCycle(int[] edges) 
    {
        boolean[] visited = new boolean[edges.length];
        Arrays.fill(visited,false);


        for(int i=0;i<edges.length;++i)
        { 
            if(!visited[i])
            {
                HashMap<Integer,Integer> distance = new HashMap<>();
                distance.put(i,0);
                DFS(edges,i,visited,distance);
            }
        }
        return ans;
    }
}
