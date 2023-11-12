class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) 
    {

        // Had to refer to one solution to get the idead that build graph based on buses;
        if(source == target)
            return 0;
        
        HashMap<Integer, List<Integer>> adj_list = new HashMap<>();
        for(int r=0; r < routes.length; ++r)
        {
            int[] route = routes[r];
            for(int i=0; i < route.length;++i)
            {
                if(!adj_list.containsKey(route[i]))
                {
                    adj_list.put(route[i],new ArrayList<Integer>());
                }
                adj_list.get(route[i]).add(r);
            }
        }
    
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int distance = 0;

        HashSet<Integer> visited = new HashSet<>();
        int[] visited_buses = new int[routes.length];
        
        while(!q.isEmpty())
        {
           int size = q.size();
           distance +=1;
           for(int i=0;i<size;++i)
           {
               int ele = q.poll();
               if(visited.contains(ele))
                    continue;

                visited.add(ele);
               List<Integer> adj_buses = adj_list.get(ele);
               if(adj_buses!= null)
               {
                   for(int j=0;j<adj_buses.size();++j)
                   {
                       int bus = adj_buses.get(j);

                       if(visited_buses[bus]==1)
                            continue;
                        visited_buses[bus] = 1;
                        for(int k=0;k<routes[bus].length;++k)
                        {
                            int stop = routes[bus][k];
                            if(stop == target)
                                return distance;
                            if(!visited.contains(stop))
                            {
                                q.add(stop);
                            }
                        }

                   }
               }                
           }
        }
        return -1;
    }
}
