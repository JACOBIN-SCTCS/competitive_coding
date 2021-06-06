class DisjointSet
{
    int[] parent;
    int[] size ;
    
    DisjointSet(int n)
    {
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0;i<n;++i)
        {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    int find(int n)
    {
        while(parent[n]!=n)
        {
            n = parent[n];
        }
        return n;
    }
    
    void union(int a, int b)
    {
        int par_a = find(a);
        int par_b = find(b);
        
        if(par_a == par_b)
            return;
        if(size[par_a]< size[par_b] )
        {
            size[par_a] += size[par_b];
            parent[par_b] = par_a;
        }
        else
        {
            size[par_b] += size[par_a];
            parent[par_a] = par_b;
        }
    }
}


class Solution 
{
    public int numSimilarGroups(String[] strs) 
    {
        DisjointSet set = new DisjointSet(strs.length);
        for(int i=0;i<strs.length;++i)
        {
            for(int j=i+1;j<strs.length;++j)
            {
                int count=0;
                for(int k=0;k<strs[i].length();++k)
                {
                    if(strs[i].charAt(k) != strs[j].charAt(k))
                    {
                        count+=1;
                    }
                    
                }
                if(count==2 || count==0)
                {
                    set.union(i,j);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<strs.length;++i)
        {
            if(set.parent[i]==i)
                ans+=1;
        }
        return ans;
    }
}
