class Solution {
    public int longestConsecutive(int[] nums) 
    {
        if(nums.length==0)
            return 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        int ans = 0;
        
        for(int i=0;i<nums.length;++i)
            set.add(nums[i]);
        
        for(int ele: set)
        {
            if(!set.contains(ele-1))
            {
                int current_streak = 1;
                int currentnum = ele;
                
                while(set.contains(currentnum+1))
                {
                    currentnum +=1;
                    current_streak+=1;
                }
                ans = Math.max(ans,current_streak);
            }
        }
        return ans;
            
    }
}
