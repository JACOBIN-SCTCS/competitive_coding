class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        long ans = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length)
        {
            min_heap.add(nums[right]);
            max_heap.add(nums[right]);

            while(left < right && Math.abs(min_heap.peek() - max_heap.peek()) > 2)
            {
                min_heap.remove(nums[left]);
                max_heap.remove(nums[left]);
                left+=1;
            }
            ans = ans + (right-left + 1);
            right+=1;
        }

        return ans;
    }
}
