class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) 
    {
       if(n==1)
           return 1; 
        
        Set<Long> s = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.add(1l);
        
        long ele= -1;
        while(n>0)
        {
            ele = pq.poll();
            for(int p:primes)
            {
                if(!s.contains(p*ele))
                {
                    s.add((long)p*ele);
                    pq.add((long)p*ele);
                }
            }
            n-=1;
        }
        return (int)ele;
        
        
    }
}
