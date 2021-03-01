
import java.util.LinkedList;

class ListNode
{
    String sval;
    double distance;
    
    ListNode(String sval, double distance)
    {
        this.sval = sval;
        this.distance = distance;
    }
}


class Solution {
    
    
    
    
    
    
    HashMap<String,List<ListNode>> adj_list = new HashMap<>();

    
    
    public double BFS(String src , String des)
    {
        HashMap<String,Double> distance = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        
        q.add(src);
        distance.put(src,(double)1.0);
        
        if(!adj_list.containsKey(src))
            return (double) -1.0;
        
        while(!q.isEmpty())
        {
            String curr = q.poll();
            if(curr.equals(des))
                return distance.get(curr);
            
            for(int i=0;i<adj_list.get(curr).size();++i)
            {
                if(!distance.containsKey(adj_list.get(curr).get(i).sval))
                {
                    q.add(adj_list.get(curr).get(i).sval);
                    distance.put( adj_list.get(curr).get(i).sval,  distance.get(curr)*adj_list.get(curr).get(i).distance );
                    
                }
            }
        }
        
        
       return -1.0; 
        
    }
    
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
       
        
        
        for(List<String> list : equations)
        {
            if(!adj_list.containsKey(list.get(0)))
            {
                adj_list.put(list.get(0),new ArrayList<ListNode>());
            
            }    
            if(!adj_list.containsKey(list.get(1)))
            {
                adj_list.put(list.get(1),new ArrayList<ListNode>());
            
            }      
        }
        
        
        for(int i=0;i<equations.size();++i)
        {
            adj_list.get(equations.get(i).get(0)).add(new ListNode(equations.get(i).get(1),values[i]));
            adj_list.get(equations.get(i).get(1)).add(new ListNode(equations.get(i).get(0),1/values[i]));

            
        }
        
        double[] res = new double[queries.size()];
        for(int i=0;i<res.length;++i)
        {
           
                res[i]=BFS(queries.get(i).get(0),queries.get(i).get(1));
        }
        return res;

    }
}
