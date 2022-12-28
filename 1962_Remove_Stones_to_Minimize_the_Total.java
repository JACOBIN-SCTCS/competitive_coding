class Solution {
    public int minStoneSum(int[] piles, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1,Collections.reverseOrder());
        int total = 0;
        for(int pile : piles)
        {
            pq.add(pile);
            total+=pile;
        }
        int removed = 0;
        for(int i=0;i<k;++i)
        {
            int ele = pq.poll();
            while(ele ==0)
                ele = pq.poll();
            
            removed = removed + (int)(Math.floor(ele/2));

            pq.add(ele-((int)(Math.floor(ele/2))));
        }
        return (total - removed);


    }
}
