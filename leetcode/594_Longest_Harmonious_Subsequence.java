class Solution {
    public int findLHS(int[] nums) {

        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int current_ele = nums[0];
        int count = 0;

        for(int i=0; i < n; ++i) {
            if(current_ele == nums[i]) {
                count+=1;
            }
            else
            {
                if(map.containsKey(current_ele-1))
                {
                    ans = Math.max(ans,count + map.get(current_ele-1));
                }
                map.put(current_ele, count);
                current_ele = nums[i];
                count = 1;
            }
        }

        if(map.containsKey(current_ele-1)) {
            ans = Math.max(ans,count + map.get(current_ele-1));
        }
        
        return ans;
    }
}
