class Solution {
    
    
    HashMap<String,PriorityQueue<String>> list = new HashMap<>();
   // HashMap<String,Integer> visited = new HashMap<>();
    List<String> ret_list = new ArrayList<String>();
    
    void DFS(String source)
    {
       
            
            PriorityQueue<String> pq = list.get(source);
            while(pq!=null && !pq.isEmpty())
            {
                
                DFS(pq.poll());
            }
            ret_list.add(source);
           
        
    }
    
    public List<String> findItinerary(List<List<String>> tickets)
    {
        for(int i=0;i<tickets.size();++i)
        {
           
            
            PriorityQueue<String> pq;
            pq = list.getOrDefault(tickets.get(i).get(0), new PriorityQueue<String>());
            pq.add(tickets.get(i).get(1));
            list.put(tickets.get(i).get(0),pq);
            
        }
        DFS("JFK");
        Collections.reverse(ret_list);
        return ret_list;
    }
}
