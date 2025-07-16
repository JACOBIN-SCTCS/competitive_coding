class Solution {
    public int maximumLength(int[] nums) {
        
        int ans = 0;

        int odd_count = 0;
        int even_count = 0;

        int last_odd_count = 0;
        int last_even_count = 0;

        for(int num : nums) {
            if((num % 2) > 0) {
                odd_count +=1;
                last_odd_count = Math.max(last_odd_count,last_even_count + 1);
            }
            else {
                even_count +=1;
                last_even_count = Math.max(last_even_count,last_odd_count + 1);
            }   
        }
        ans = Math.max(ans, Math.max(last_odd_count,last_even_count));
        ans = Math.max(ans, Math.max(odd_count,even_count));
        return ans;
    }
}
