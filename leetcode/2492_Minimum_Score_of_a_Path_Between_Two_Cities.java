class DisjointSet
{
    int[] set;    
    int[] rank;

    
    DisjointSet(int n)
    {
        set = new int[n];
        for(int i=0;i<n;++i)
        {
            set[i]=i;
        }
        rank = new int[n];
    }

    int find(int ele)
    {
       if(set[ele]!=ele)
            set[ele] = find(set[ele]);
        return set[ele];
        
    }
    void union(int a , int b)
    {
        int parent_a = find(a);
        int parent_b = find(b);
        
        if(parent_a==parent_b)
            return;
        
        if(rank[parent_a] < rank[parent_b])
        {
            set[parent_b] = parent_a;

        }
        else if(rank[parent_a] > rank[parent_b])
        {
            set[parent_a] = parent_b;
        }
        else
        {
            set[parent_a] = parent_b;
            rank[parent_b] +=1;
        }


    }
}

class Solution {
    
    
    public int minScore(int n, int[][] roads) 
    {
        DisjointSet d = new DisjointSet(n);
        for(int i=0;i<roads.length;++i)
        {
            d.union(roads[i][0]-1,roads[i][1]-1);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<roads.length;++i)
        {
            if(d.find(0)==d.find(roads[i][1]-1))
            {
                ans = Math.min(ans,roads[i][2]);
            }
        }
        return ans;

    }
}
