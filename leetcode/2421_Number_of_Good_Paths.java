
class UnionFind
{
    int[] parent;
    int[] rank ;

    UnionFind(int n)
    {
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i=0;i<n;++i)
            parent[i] = i;
    }

    public int find(int n)
    {
        while(parent[n]!=n)
            n = parent[n];
        
        return n;
    }

    public void union(int ele1, int ele2)
    {
        int rep1 = this.find(ele1);
        int rep2 = this.find(ele2);

        if(rep1==rep2)
            return;

        if(rank[rep1]<rank[rep2])
        {
            parent[rep1] = rep2;
        }
        else if(rank[rep2]> rank[rep1])
        {
            parent[rep2] = rep1;
        }
        else
        {
            parent[rep1] = rep2;
            rank[rep1] +=1;
        }
        
    }
}

class Solution 
{
    public int numberOfGoodPaths(int[] vals, int[][] edges) 
    {
        int n = vals.length;
        int ans = 0;
        UnionFind uf = new UnionFind(n);
        List<List<Integer>> adj_list = new ArrayList<List<Integer>>();
        
        
        for(int i=0;i<n;++i)
            adj_list.add(new ArrayList<Integer>());

        for(int i = 0; i<edges.length;++i)
        {   
           adj_list.get(edges[i][0]).add(edges[i][1]);
           adj_list.get(edges[i][1]).add(edges[i][0]);
        }   

        TreeMap<Integer,List<Integer>> tm = new TreeMap<>();

        for(int i =0 ; i < vals.length;++i)
        {
            tm.computeIfAbsent(vals[i],val -> new ArrayList<Integer>()).add(i);
        }

        for(int key : tm.keySet())
        {
            List<Integer> list = tm.get(key);
            for(int i=0;i<list.size();++i)
            {
                int node = list.get(i);
                for(int j =0 ; j<adj_list.get(node).size();++j)
                {
                    int neighbour = adj_list.get(node).get(j);
                    if(vals[neighbour]<=vals[node])
                    {
                        uf.union(neighbour,node);
                    }
                }

            }

            HashMap<Integer,Integer> countmap = new HashMap<>();
            for(int i=0;i<list.size();++i)
            {
                int component = uf.find(list.get(i));
                if(!countmap.containsKey(component))
                    countmap.put(component,1);
                else
                    countmap.put(component,countmap.get(component)+1);
            }

            for(int root : countmap.keySet())
            {
                ans = ans + (countmap.get(root)*(countmap.get(root)+1))/2 ;
            } 

        }

        return ans;
    }
}
