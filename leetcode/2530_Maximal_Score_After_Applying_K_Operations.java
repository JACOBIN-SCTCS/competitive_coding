class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
            @Override
            public int compare(Integer s1, Integer s2)
            {
                return s2.compareTo(s1);
            }
        });

        for(int num : nums)
            pq.add(num);

        while(k > 0)
        {
            if(pq.size() > 0)
            {
                int ele = pq.poll();
                score = score + ele;

                ele = (int) Math.ceil((1.0*ele)/3);
                pq.add(ele);
            }
            k-=1;
        }
        return score;
    }
}
