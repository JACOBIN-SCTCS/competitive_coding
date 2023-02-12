class Solution {
    
    long ans = 0l;

    public long DFS(HashMap<Integer,List<Integer>> adj_list,int vertex,int[] visited, int seats)
    {
        List<Integer> neighbours = adj_list.get(vertex);
        long count = 1l;
        visited[vertex] = 1;
        for(int i=0;i<neighbours.size();++i)
        {   
            if(visited[neighbours.get(i)]==1)
                continue;
            count = count + DFS(adj_list,neighbours.get(i),visited,seats);
        }

        long quotient = count / seats;
        long reminder = count % seats;

        if(vertex != 0)
        {
            if(reminder != 0)
            {
                ans = ans + quotient + 1;
            } 
            else
            {
                ans = ans + quotient;
            }  
        }
        return count;
    }
    public long minimumFuelCost(int[][] roads, int seats) 
    {
        HashMap<Integer,List<Integer>> adj_list = new HashMap<>();
        if(roads.length==0)
            return 0;

        for(int i=0;i<roads.length;++i)
        {
            if(!adj_list.containsKey(roads[i][0]))
                adj_list.put(roads[i][0],new ArrayList<Integer>());
            adj_list.get(roads[i][0]).add(roads[i][1]);
          
            if(!adj_list.containsKey(roads[i][1]))
                adj_list.put(roads[i][1],new ArrayList<Integer>());
            adj_list.get(roads[i][1]).add(roads[i][0]);
        }
        int[] visited = new int[adj_list.size()];
        long count = DFS(adj_list,0,visited,seats);
        return ans;
        

    }
}
