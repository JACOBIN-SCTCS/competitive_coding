class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
       
        
        int[][] distance = new int[n][n];
        final int INF = 10000000; 
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                distance[i][j]=INF;
            }
        }
        
        for(int i=0;i<edges.length;++i)
        {
            distance[edges[i][0]][edges[i][1]] = edges[i][2];
            distance[edges[i][1]][edges[i][0]] = edges[i][2];

        }
        
        
        
        for(int k=0;k<n;++k)
        {
            for(int i=0;i<n;++i)
            {
                for(int j=0;j<n;++j)
                {
                    distance[i][j] =Math.min(distance[i][j], distance[i][k]+distance[k][j]);
                }
            }
        }
        
        
        
        int[] reachable = new int[n];
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(i!=j && distance[i][j]<=distanceThreshold)
                {
                    reachable[i]+=1;
                }
            }
        }
        
        int small=reachable[0];
        int idx = 0;
        
        for(int i=1;i<reachable.length;++i)
        {
            if(reachable[i]<=small)
            {
                small=reachable[i];
                idx=i;
            }
        }
        return idx;
        
        
        
        
    }
}
