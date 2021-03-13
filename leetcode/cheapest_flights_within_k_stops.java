
class AdjListNode
{
    int dest;
    int weight;
    
    AdjListNode(int dest,int weight)
    {
        this.weight=weight;
        this.dest= dest;
    }
}

class Solution 
{
    
    int min_cost = Integer.MAX_VALUE;
    
    public void DFS(List<List<AdjListNode>> adj_list,int src,int dest,int k, int cost)
    {
        if(src==dest && k>=0)
        {
            min_cost=Math.min(min_cost,cost);
            return;
        }
        if(k<0)
            return;
        
       
        for(int i=0;i<adj_list.get(src).size();++i)
        {
           if( cost+adj_list.get(src).get(i).weight<min_cost)
                DFS(adj_list,adj_list.get(src).get(i).dest,dest,k-1,cost+adj_list.get(src).get(i).weight);
        }
       
        
        
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) 
    {
        List<List<AdjListNode>> adj_list = new ArrayList<List<AdjListNode>>();
        
        
        for(int i=0;i<n;++i)
        {
            adj_list.add(new ArrayList<AdjListNode>());
        }
        
        for(int i=0;i<flights.length;++i)
        {
            adj_list.get(flights[i][0]).add(new AdjListNode(flights[i][1],flights[i][2]));
        }
        
        DFS(adj_list,src,dst,K+1,0);
        if(min_cost==Integer.MAX_VALUE)
            min_cost=-1;
        
        return min_cost;
        
        
    }
}
