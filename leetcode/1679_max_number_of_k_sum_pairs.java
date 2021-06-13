class Solution {
    public int maxOperations(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;++i)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else
            {
                map.put(nums[i],1);
            }
            
        }
        
        int ans = 0;
        if(k%2==0)
        {
            int mid = k/2;
            if(map.containsKey(mid))
            {
                ans = ans + map.get(mid)/2;
                map.put(mid,0);
            }
            
        
        }
        for(int key:map.keySet())
        {
            int diff = k - key;
            if(map.containsKey(diff))
            {
                int freq_key = map.get(key);
                int freq_diff = map.get(diff);
                int min = Math.min(freq_key,freq_diff);
                ans += min;
                
                map.put(key,freq_key-min);
                map.put(diff,freq_diff-min);
            }
        }
        return ans;
        
        
    }
}
