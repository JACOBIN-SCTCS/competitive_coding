class Solution 
{
    public int DFS(List<List<Integer>> adj_list, int source, int[] visited)
    {
        
        visited[source] = 1;
        int count = 1;

        for(int i=0;i<adj_list.get(source).size();++i)
        {
            if(visited[adj_list.get(source).get(i)]==0)
                count = count + DFS(adj_list,adj_list.get(source).get(i),visited);
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) 
    {
        int n = bombs.length;
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();

        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (i == j) 
                {
                    continue;
                }
                int xi = bombs[i][0];
                int yi = bombs[i][1];
                int ri = bombs[i][2];
                int xj = bombs[j][0];
                int yj = bombs[j][1];

                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                   adj_list.get(i).add(j);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<adj_list.size();++i)
        {
            int[] visited = new int[n];
            ans = Math.max(ans,DFS(adj_list,i,visited));
        }
        return ans;
    }
}
