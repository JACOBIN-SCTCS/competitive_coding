class DisjointSet
{
    int[] parent;
    
    DisjointSet(int n)
    {
        parent = new int[n+1];
        for(int i=1;i<=n;++i)
            parent[i] = i;
    }
    
    int find(int a)
    {
        while(parent[a]!=a)
            a = parent[a];
        return a;
    }
    
    boolean union(int a, int b)
    {
        int par_a = find(a);
        int par_b = find(b);
        
        if(par_a == par_b)
            return false;
        
        parent[par_a] = par_b;
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        DisjointSet set = new DisjointSet(edges.length); 
        for(int[] edge:edges)
        {
            if(!set.union(edge[0],edge[1]))
            {
                return edge;
            }
        }
        return new int[2];
        
    }
}
