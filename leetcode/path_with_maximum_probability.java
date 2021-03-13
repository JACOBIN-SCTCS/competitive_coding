
class AdjListNode
{
    int dest;
    double weight;
    
    AdjListNode(int dest,double weight)
    {
        this.dest = dest;
        this.weight=weight;
    }
}




class ListNodeComparator implements Comparator<AdjListNode>
{
    @Override
    public int compare(AdjListNode node1 , AdjListNode node2)
    {
        if(node1.weight>node2.weight)
            return -1;
            
        if(node1.weight<node2.weight)
            return 1;
        
        return 0;
    }

}




class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) 
    {
        List<List<AdjListNode>> adj_list = new ArrayList<List<AdjListNode>>();
        
        for(int i=0;i<n;++i)
        {
            adj_list.add(new ArrayList<AdjListNode>());
        }
        for(int i=0;i<edges.length;++i)
        {
           
            adj_list.get(edges[i][0]).add(new AdjListNode(edges[i][1],succProb[i]));
            adj_list.get(edges[i][1]).add(new AdjListNode(edges[i][0],succProb[i]));

        }
        
        PriorityQueue<AdjListNode> pq = new PriorityQueue(n,new ListNodeComparator());
        Set<Integer> visited = new HashSet<>();
        
        pq.add(new AdjListNode(start,1));
        
        double[] distance = new double[n];
        
        for(int i=0;i<n;++i)
        {
            distance[i] = Double.MIN_VALUE;
            
        }
        distance[start]=(double)1;
        
        while(!pq.isEmpty())
        {
            AdjListNode curr = pq.poll();
            if(curr.dest==end)
                break;
                
            if(!visited.contains(curr.dest))
            {
              for(AdjListNode neighbour : adj_list.get(curr.dest))   
              {
                if(distance[neighbour.dest]<(distance[curr.dest]*neighbour.weight))
                {
                    distance[neighbour.dest] = distance[curr.dest]*neighbour.weight;
                    pq.add(new AdjListNode(neighbour.dest,distance[neighbour.dest]));
                }
                
              }
            }
            
        }
        
        if(distance[end]==Double.MIN_VALUE)
            return 0;
        return distance[end];
        
        
        
    }
}
