```
class Solution {
    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i=0;i<stones.length;++i)
        {
            pq.add(stones[i]);
            
        }
        
        while(pq.size()>1)
        {
            int ele1 = pq.poll();
            if(pq.peek()==null)
                return ele1;
            
            int ele2= pq.poll();
            if(ele1!=ele2)
            {
                pq.add(ele1-ele2);
            }
        }
        
        if(pq.peek()==null)
            return 0;
        else
            return pq.peek();
        
    }
}
```
