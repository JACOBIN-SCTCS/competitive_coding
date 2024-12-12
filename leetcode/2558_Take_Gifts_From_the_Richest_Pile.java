class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int gift : gifts)
            pq.add(gift);

        for(int i=0; i < k; ++i )
        {
            if(pq.isEmpty())
            {
                return 0;
            }
            int ele = pq.poll();
            int square_root =(int)Math.sqrt(ele);
            if(square_root > 0)
                pq.add(square_root);

        }
        long remaining = 0;
        while(!pq.isEmpty())
            remaining += pq.poll();
        return remaining;
    }
}
