class Solution {
    public int largestAltitude(int[] gain) 
    {
        int ans = 0;
        int run_sum = 0;
        for(int i=0;i<gain.length;++i)
        {
           run_sum += gain[i];
           ans = Math.max(ans,run_sum);
        }    
        return ans;
    }
}
