class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Referred editorial for Prority Queue based solution
        int mod = 1000000007;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b)
                {
                    return a[0] - b[0];
                }
            }
        );
        for(int i=0 ; i < nums.length; ++i)
        {
            pq.add(new int[]{nums[i],i});
        }
        int ans = 0;
        for(int i=1 ; i <= right; ++i)
        {
            int[] polled = pq.poll();
            if(i>= left)
            {
                ans = (ans + polled[0])%mod;
            }
            if(polled[1] < nums.length-1)
            {
                polled[1] = polled[1] + 1;
                polled[0] = polled[0] + nums[polled[1]];
                pq.add(polled);
            }
            
        }

        return ans;
    }
}
