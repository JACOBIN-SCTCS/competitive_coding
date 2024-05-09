class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        long ans = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        for(int i=0; i < k ; ++i)
        {
            if(happiness[n-1-i] - i  > 0)
                ans = ans + (happiness[n-1-i]-i);
        }
        return ans;
    }
}
