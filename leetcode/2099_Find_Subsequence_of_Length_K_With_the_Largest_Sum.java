class Solution {
    
    class PQElement {
        int idx;
        int ele;

        PQElement(int idx, int ele) {
            this.idx = idx;
            this.ele = ele;
        }
    }
    
    public int[] maxSubsequence(int[] nums, int k) {
        
        int[] ans = new int[k];
        
        PriorityQueue<PQElement> pq = new PriorityQueue<PQElement>(1, new Comparator<PQElement>() {
            @Override 
            public int compare(PQElement a, PQElement b) {
                return (b.ele - a.ele);
            }

        });
        for(int i=0 ; i < nums.length; ++i)
            pq.add(new PQElement(i, nums[i]));

        int idx = 0;

        int[] temp = new int[k];
        while(idx < k)
        {
            PQElement ele = pq.poll();
            temp[idx] = ele.idx;
            idx+=1;
        }

        Arrays.sort(temp);
        for(int i=0; i < k ; ++i)
            ans[i] = nums[temp[i]];

        return ans;
    
    }
}
