class DisjointSet
{
    int[] set;
    int no_components;
    
    
    
    DisjointSet(int n)
    {
        set = new int[n];
        for(int i=0;i<n;++i)
        {
            set[i]=i;
        }
        no_components = n;
    }
    
    
    
    
    int find(int ele)
    {
        if(set[ele]==ele)
            return ele;
        
        return find(set[ele]);
    }
    
    
    
    
    void union(int a , int b)
    {
        int parent_a = find(a);
        int parent_b = find(b);
        
        if(parent_a!=parent_b)
        {
            set[parent_a] = parent_b;
            no_components-=1;
        }
    }


}

class Solution {
    public int findCircleNum(int[][] isConnected)
    {
        DisjointSet set = new DisjointSet(isConnected.length);
        for(int i=0;i<isConnected.length;++i)
        {
            for(int j=0;j<isConnected[i].length;++j)
            {
                if(isConnected[i][j]==1)
                {
                    set.union(i,j);
                }
            }
        }
        
        return set.no_components;
    }
}
