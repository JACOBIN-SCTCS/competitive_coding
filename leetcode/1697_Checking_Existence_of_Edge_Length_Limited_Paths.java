
class DisjointSet
{
    int n;
    int[] parent;
    int[] rank;

    DisjointSet(int n)
    {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;++i)
        {
            this.parent[i] = i;
        }
    }

    int find(int id)
    {
       while(id != this.parent[id])
        {
            id = this.parent[id];
        }
       return id;
    }

    void union(int id1, int id2)
    {
        int root_1 = find(id1);
        int root_2 = find(id2);
    
        if(root_1 != root_2)
        {
            if(this.rank[root_1] >= this.rank[root_2])
            {
                this.parent[root_2] = root_1;
                this.rank[root_1] +=1;
            }
            else
            {
                this.parent[root_1] = root_2;
                this.rank[root_2] +=1;
            }
        }
    }
  
};

class Solution 
{
    // Took hints from Editorial.
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) 
    {
        boolean[] ans = new boolean[queries.length];
        DisjointSet ds = new DisjointSet(n);

        Arrays.sort(edgeList, new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b)
            {
                return a[2] - b[2];
            }
        });
        
        int[][] queries_with_order = new int[queries.length][4];
        for(int i=0;i<queries.length;++i)
        {
            queries_with_order[i][0] = queries[i][0];
            queries_with_order[i][1] = queries[i][1];
            queries_with_order[i][2] = queries[i][2];
            queries_with_order[i][3] = i;
        }

        Arrays.sort(queries_with_order, new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b)
            {
                return a[2] - b[2];
            }
        });
        
        int j = 0;
        for(int i=0;i<queries_with_order.length;++i)
        {
            while(j<edgeList.length && edgeList[j][2] < queries_with_order[i][2])
            {
                ds.union(edgeList[j][0],edgeList[j][1]);
                j+=1;
            }
            int root_1 = ds.find(queries_with_order[i][0]);
            int root_2 = ds.find(queries_with_order[i][1]);
            if(root_1 == root_2)
                ans[queries_with_order[i][3]] = true;
            else
                ans[queries_with_order[i][3]] = false;
        }
        return ans;

    }
}
