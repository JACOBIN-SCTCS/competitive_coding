class Node
{
    int key;
    int value;
    
    Node(int key,int value)
    {
        this.key = key;
        this.value=value;
    }
}


class NodeComparator implements Comparator<Node>
{
   @Override
    public int compare(Node n1,Node n2)
    {
        if(n1.value>n2.value)
            return -1;
        else if(n1.value<n2.value)
            return 1;
            
        return 0;
    }
    

}

class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
        {
            if(map.containsKey(num))
            {
                map.put(num,map.get(num)+1);
            }
            else
            {
                map.put(num,1);
            }
            
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(nums.length,new NodeComparator());
        for(int num : map.keySet())
        {
            pq.add(new Node(num,map.get(num)));
        }
        
        int[] ret = new int[k];
        int ptr =0;
        while(k>0)
        {
            ret[ptr]=pq.poll().key;
            ptr+=1;
            k-=1;
        }
        
        return ret;
        
        
            
    }
}
