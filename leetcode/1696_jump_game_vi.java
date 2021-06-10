


class Solution {
    public int maxResult(int[] nums, int k) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        int res = nums[0];
        
        for(int i=1;i<nums.length;++i)
        {
            while(!pq.isEmpty() && pq.peek()[1]<i-k)
                pq.poll();
            if(pq.isEmpty())
                pq.add(new int[]{nums[i],i});
            else
            {
                res = pq.peek()[0] + nums[i];
                pq.add(new int[]{res,i});
            }
        }
        return res;
    }
}
