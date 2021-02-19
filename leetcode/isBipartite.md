```
class Solution {
    
    
     int color[];
    
    
    public boolean DFS(int[][] graph,int i, int new_color)
    {
        if(color[i]!=0)
            return color[i]==new_color;
        else
        {    
            color[i]=new_color;
            for(int j=0;j<graph[i].length;++j)
            {
                if(!DFS(graph,graph[i][j],color[i]*-1))
                    return false;
            }
            
            
        }
        return true;
        
        
    }
    
    
    
    public boolean isBipartite(int[][] graph) {
        
        color = new int[graph.length+1];
        for(int i=0;i<graph.length;++i)
        {
            if(color[i]==0)
            {
                if (!DFS(graph,i,1))
                    return false;   
            }
        }
        return true;
        
    }
}
```
