class Solution {
    public int nthUglyNumber(int n) 
    {
        int[] values = new int[]{2,3,5};
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        HashSet<Long> s = new HashSet<>();
        
        int count=0;
        pq.add(1l);
        if(n==1)
            return 1;
        
        
        s.add(1l);
        while(count!=n)
        {
            long ele = pq.remove();
            count+=1;
            if(count==n)
                return (int)ele;
            
            for(int i=0;i<3;++i)
            {
                if(!s.contains(values[i]*ele))
                {
                    s.add(values[i]*ele);
                    pq.add(values[i]*ele);
                }
            }

            
        }
        
        return 0;
        
        
        
    }
}
