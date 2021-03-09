class Solution {
    public int maximumScore(int a, int b, int c) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        
        int score = 0;
        
        while(pq.size()>=2)
        {
            int top1 = pq.poll();
            int top2 = pq.poll();
            score+=1;
            
            top1-=1;
            top2-=1;
            
            if(top1>=1)
                pq.add(top1);
            
            if(top2>=1)
                pq.add(top2);
            
        }
        
        return score;
    }
    
}
