class Solution {
    public int countCompleteSubarrays(int[] nums) {

        int n = nums.length;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i < n; ++i)
            set.add(nums[i]);

        int distinct = set.size();
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int ans = 0;
        int right = 0;
        int count = 0;

        for(int left = 0 ; left < n ; ++left)
        {
            if(left > 0)
            {
                int prev_element = nums[left-1];
                int cnt = map.get(prev_element);
                if(cnt-1 == 0)
                {
                    count-=1;
                    map.remove(prev_element);
                }
                else
                {
                    map.put(prev_element, cnt-1);
                }
            }
            while(right < n  && map.size() < distinct)
            {
                map.put(nums[right] , map.getOrDefault(nums[right],0) + 1);
                right+=1;
            }

            if(map.size() == distinct)
            {
                ans = ans + (n-right + 1);
            }
        }

        return ans;
    }
}
