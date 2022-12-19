class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();

        for(int i=0;i<n;++i)
        {
            adj_list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;++i)
        {
            adj_list.get(edges[i][0]).add(edges[i][1]);
            adj_list.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];

        q.add(source);
        while(! q.isEmpty())
        {
            int ele = q.poll();
            visited[ele] = 1;
            if(ele == destination)
            {
                return true;
            }
            for(int i=0;i<adj_list.get(ele).size();++i)
            {
                int curr = adj_list.get(ele).get(i);
                if(visited[curr]!=1)
                {
                    q.add(curr);
                    visited[curr]=1;
                }
            }
        }
        return false;

    }
}
