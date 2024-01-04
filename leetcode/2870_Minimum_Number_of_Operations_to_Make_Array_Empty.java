class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i =0 ; i < nums.length; ++i)
        {
            if(count.containsKey(nums[i]))
                count.put(nums[i] , count.get(nums[i]) + 1);
            else
                count.put(nums[i] , 1);
        }

        int ans = 0;
        for(int key : count.keySet())
        {
            int val = count.get(key);
            if(val == 1)
                return -1;
            
            // HAD TO REFER EDITORIAL FOR math.ceil()
            ans += Math.ceil((double) val / 3);

        }
        return ans;
    }
}
