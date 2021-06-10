

class DisjointSet
{
    int[] parent;
    int component;
    
    DisjointSet(int n)
    {
        parent = new int[n];
        this.component=n;
        for(int i=0;i<n;++i)
            parent[i]=i;
    }
    
    int find(int ele)
    {
        while(parent[ele]!=ele)
        {
            ele = parent[ele];
        }
        return parent[ele];
    }
    
    boolean union(int a, int b)
    {
        int par_a = find(a);
        int par_b = find(b);
        if(par_a!=par_b)
        {
            parent[par_a] = par_b;
            component-=1;
            return true;
        }
        return false;
    }
        
        
}

class Edge
{
    int p1;
    int p2;
    int distance;
    
    
    Edge(int p1, int p2, int distance)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) 
    {
           
        List<Edge> edges = new ArrayList<Edge>();
        for(int i=0;i<points.length;++i)
        {
            for(int j=i+1;j<points.length;++j)
            {
                edges.add(new Edge(i,j,Math.abs(points[i][0]-points[j][0])+ Math.abs(points[i][1]-points[j][1])));
            }
        }
        
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2)
            {
                return Integer.compare(e1.distance,e2.distance);
            }
        });
        
        DisjointSet set = new DisjointSet(points.length);
        int idx = 0;
        int cost=0;
        
        while(set.component!=1 && idx<edges.size())
        {
            boolean res = set.union(edges.get(idx).p1, edges.get(idx).p2);
            if(res==true)
                cost += edges.get(idx).distance;
            idx+=1;
            
        }
        return cost;
        
        
    }
}
