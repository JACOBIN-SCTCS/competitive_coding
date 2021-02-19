```
class Solution {
   
    List<List<Integer>> dislike_graph = new ArrayList<List<Integer>>();
    int color[];
    
    
    
    public boolean DFS(int i, int new_color)
    {
        if(color[i]!=0)
            return color[i]==new_color;
        else
        {    
            color[i]=new_color;
            for(int j=0;j<dislike_graph.get(i).size();++j)
            {
                if(!DFS(dislike_graph.get(i).get(j),color[i]*-1))
                    return false;
            }
            
            
        }
        return true;
        
        
    }
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        if(N==1||N==2)
            return true;
        
        
        color = new int[N+1];
        
        for(int i=0;i<N+1;++i)
            dislike_graph.add(new ArrayList<Integer>());
        
        for(int i=0;i<dislikes.length;++i)
        {
            dislike_graph.get(dislikes[i][1]).add(dislikes[i][0]);
            dislike_graph.get(dislikes[i][0]).add(dislikes[i][1]);
        }
        
        for(int i=1;i<N+1;++i)
        {
            if(color[i]==0)
            {
                if (!DFS(i,1))
                    return false;   
            }
        }
        
        return true;
    }
}
```
