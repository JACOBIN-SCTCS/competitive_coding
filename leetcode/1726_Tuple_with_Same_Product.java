class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();

        for(int i=0 ; i < nums.length; ++i)
        {
            for(int j=0; j < i ; ++j)
            {
                int product = nums[i]*nums[j];
                count.put(product,count.getOrDefault(product,0) + 1);
            }
        }

        int ans = 0;
        for(int key : count.keySet())
        {
            int c = count.get(key);
            if(c>1)
            {
                ans = ans + ((c*(c-1))>>1)*8;
            }
        }
        return ans;
    }
}
