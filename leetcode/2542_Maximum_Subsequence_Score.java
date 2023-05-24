class Solution 
{
    public long maxScore(int[] nums1, int[] nums2, int k) 
    {
        // Had to refer editorial for implementation idea 
        int n = nums1.length;
        int[][]  pairs = new int[n][2];

        for(int i=0;i<n;++i)
        {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a , int[] b)
            {
                return b[1] - a[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long top_k_sum = 0;
        long ans = 0;

        for(int i=0; i < k ; ++i)
        {
            top_k_sum = top_k_sum + pairs[i][0];
            pq.add(pairs[i][0]);
        }
        ans = Math.max(ans , top_k_sum * pairs[k-1][1]);

        for(int i=k;i<n;++i)
        {
            int top_ele = pq.poll();
            top_k_sum = top_k_sum - top_ele;
            top_k_sum = top_k_sum + pairs[i][0];
            pq.add(pairs[i][0]);
            ans = Math.max(ans, top_k_sum * pairs[i][1]);
        }
        // for(int i=0;i<n;++i)
        // {
        //     System.out.println(pairs[i][0] + "  " + pairs[i][1]);
        // }
        return ans;
    }
}
