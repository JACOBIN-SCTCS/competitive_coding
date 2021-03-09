
class ListNode
{
    int dest;
    int weight;
    
    ListNode(int d,int weight)
    {
        this.dest =d;
        this.weight=weight;
    }
}


class NodeComparator implements Comparator<ListNode>
{
    @Override
    public int compare(ListNode node1, ListNode node2)
    {
        if(node1.weight<node2.weight)
            return -1;
        if(node1.weight>node2.weight)
            return 1;
        
        return 0;
    }
}




class Solution 
{
    
    int[] distance;
    Set<Integer> visited;
    
    public void dijkstras(List<List<ListNode>> adj_list,int source)
    {
       
        
        PriorityQueue<ListNode> q  = new PriorityQueue<>(adj_list.size(),new NodeComparator());
        ListNode sourcenode = new ListNode(source,0);
        q.add(sourcenode);
        distance[source]=0;
        
        while(!q.isEmpty())
        {
            ListNode curr = q.poll();
            //System.out.print(curr.weight);
           // System.out.print(curr.dest +"\n");
            
            if(!visited.contains(curr.dest))
            {
               visited.add(curr.dest);
                for(ListNode node:adj_list.get(curr.dest))
                {
                    if(distance[node.dest]> distance[curr.dest]+node.weight)
                    {
                        distance[node.dest] = distance[curr.dest]+node.weight;
                        q.add(new ListNode(node.dest,distance[node.dest]));
                    }
                }
            }
            
        }
        
        
        
    }
    
    
    
    
    public int networkDelayTime(int[][] times, int n, int k)
    {
        
        List<List<ListNode>> adj_list = new ArrayList<List<ListNode>>();
    
        
        for(int i=0;i<n+1;++i)
        {
            adj_list.add(new ArrayList<ListNode>());
        }
        
        for(int i=0;i<times.length;++i)
        {
            adj_list.get(times[i][0]).add(new ListNode(times[i][1],times[i][2]));
        }
        
        distance  = new int[n+1];
        
        for(int i=0;i<(n+1);++i)
        {
            distance[i] = Integer.MAX_VALUE;
            
        }
        visited = new HashSet<Integer>();
        
        dijkstras(adj_list,k);
        
        if(!(visited.size()==n))
            return -1;
        
        int max=-1;
        for(int i=1;i<distance.length;++i)
        {
            if(max<distance[i])
            {
                max=distance[i];
            }
        }
        
        return max;
    }
}
