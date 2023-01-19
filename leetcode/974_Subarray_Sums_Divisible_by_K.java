class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       int prefix_sum = 0;
       int ans = 0;
       for(int num : nums){
           prefix_sum = (prefix_sum  + num%k + k)%k;
           int reminder = prefix_sum;
            if(reminder == 0)
                ans+=1;
            if(!map.containsKey(reminder))
            {
                map.put(reminder,1);
            }
            else
            {
                ans = ans + map.get(reminder);
                map.put(reminder,map.get(reminder)+1);
            }

       }    
       return ans;

    }
}
