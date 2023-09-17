class Solution {
    public int shortestPathLength(int[][] graph) 
    {
        int n = graph.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        Queue<List<Integer>> q = new LinkedList<>();

        for(int i=0;i<n;++i)
        {
            int mask = (1<<i);
            mask = mask | ( 1<<(n+i)) ; 
            dp.put(mask,0);
            List<Integer> l = new ArrayList<Integer>();
            l.add(i);
            l.add(mask);
            q.add(l);
        }

        int target = ((int)(Math.pow(2,n))) - 1;
        while(!q.isEmpty())
        {
           for(int i=0;i<q.size();++i)
           {
             List<Integer> popped = q.poll();
             int current = popped.get(0);
             int current_mask = popped.get(1);

             if((current_mask & target) == target)
                return dp.get(current_mask);

             for(int j=0;j<graph[current].length;++j)
             {
                int neighbour = graph[current][j];
                int new_mask = (current_mask & target) | (1<<neighbour) ;
                new_mask  = new_mask | (1<<(n+neighbour));
                if(dp.containsKey(new_mask))
                    continue;
                dp.put(new_mask, dp.get(current_mask) + 1);
                List<Integer> new_ele = new ArrayList<Integer>();
                new_ele.add(neighbour);
                new_ele.add(new_mask);
                q.add(new_ele);
             }
           }
        }
        return 0;
    }
}
