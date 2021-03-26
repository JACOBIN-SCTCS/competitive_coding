class Solution {
    public int findCenter(int[][] edges) 
    {
        
        int n = edges.length+1;
        int[] count = new int[n+1];
        
      
        
        for(int i=0;i<edges.length;++i)
        {
            if(count[edges[i][0]]>=1)
                return edges[i][0];
            
            if(count[edges[i][1]]>=1)
                return edges[i][1];
            
            count[edges[i][0]]+=1;
            count[edges[i][1]]+=1;
        }
        
        int center = 0;    
        for(int i=1;i<=n;++i)
        {
            if(count[i]==(n-1))
            {
                center=i;
            }
        }
        
        return center;
    
    }
}
