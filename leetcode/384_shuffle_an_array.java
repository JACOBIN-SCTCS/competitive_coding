class Solution {

    int[] nums;
    int[] work;
    Random random = new Random();
    
    public Solution(int[] nums) {
        
        this.nums = nums;
        work = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        work = nums;
        nums = nums.clone();
        return work;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int ptr = 0;
        while(ptr<work.length)
        {
            int swap_idx = random.nextInt(work.length-ptr)+ptr;
            int tmp  = work[ptr];
            work[ptr] = work[swap_idx];
            work[swap_idx] = tmp;
            ptr+=1;
        }
        return work;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
