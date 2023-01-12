class Solution {
    
    int[] ans;

    public int[] DFS(List<List<Integer>> adj_list,
        int source, 
        int[] visited, 
        String labels)
    {
        
        int[] count = new int[26];
        count[(int)(labels.charAt(source)-'a')] = 1;
        visited[source] = 1;

        for(int i=0;i<adj_list.get(source).size();++i)
        {
            int end_vertex = adj_list.get(source).get(i);
            if (visited[end_vertex] == 1)
                continue;
            int[] ret = DFS(adj_list,end_vertex,visited,labels);
            for(int j=0;j<ret.length;++j)
            {
                count[j] = count[j] + ret[j];
            }
        }
        ans[source] = count[(int)(labels.charAt(source)-'a')];
        return count;
    }    
    public int[] countSubTrees(int n, int[][] edges, String labels) 
    {
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        ans = new int[n];

        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());
        
        int[] visited = new int[n];
        for(int i=0;i<edges.length;++i)
        {
            int[] edge = edges[i];
            adj_list.get(edge[0]).add(edge[1]);
            adj_list.get(edge[1]).add(edge[0]);
        }

        int[] tmp = DFS(adj_list,0,visited,labels);
        return ans;

    }
}
