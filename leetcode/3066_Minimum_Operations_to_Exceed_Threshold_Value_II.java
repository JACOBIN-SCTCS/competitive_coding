class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i=0; i < nums.length; ++i)
            pq.add((long)nums[i]);
        int ans = 0;
        while(!pq.isEmpty())
        {
            long top = pq.peek();
            if(top < k)
            {
                long n1 = pq.poll();
                if(!pq.isEmpty())
                {
                    long n2 = pq.poll();
                    pq.add( Math.min(n1,n2) * 2 + Math.max(n1,n2));
                    ans += 1;

                }
         
            }
            else
            {
                break;
            }
        }
        return ans;
    }
}
