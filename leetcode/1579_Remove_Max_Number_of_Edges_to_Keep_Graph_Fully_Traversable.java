class DisjointSet
{
    int n;
    int[] parent;
    int n_components;
    int[] rank;

    DisjointSet(int n)
    {
        this.n = n;
        this.n_components = n;
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

    boolean union(int id1, int id2)
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
            this.n_components = this.n_components-1;
            return false;
        }
        return true;
    }
  
};

class Solution 
{
    public int maxNumEdgesToRemove(int n, int[][] edges) 
    {
       DisjointSet alice = new DisjointSet(n+1);
       DisjointSet bob = new DisjointSet(n+1);
       int ans = 0;

       Arrays.sort(edges, new Comparator<int[]>(){
           @Override
            public int compare(int[] e1 , int[] e2)
            {
                return (e2[0]-e1[0]);
            }
       });

       for(int i=0;i<edges.length;++i)
       {
           int node_1 = edges[i][1];
           int node_2 = edges[i][2];

           if(edges[i][0]==1)
           {
               boolean res = alice.union(node_1,node_2);
               if(res)
                    ans+=1;
           }
           else if(edges[i][0]==2)
           {
              boolean res =  bob.union(node_1,node_2);
              if(res)
                    ans+=1;
           }
           else
           {
               boolean res1 = alice.union(node_1,node_2);
               boolean res2 = bob.union(node_1,node_2);

               if(res1==true && res2==true)
                    ans+=1;
           }
       }
       if(alice.n_components != 2 || bob.n_components != 2)
        return -1;
    
       return ans;

    }
}
