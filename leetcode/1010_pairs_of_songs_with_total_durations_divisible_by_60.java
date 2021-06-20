class Solution {
    public int numPairsDivisibleBy60(int[] time) 
    {
        int[] count = new int[60];
        int ans = 0;
        for(int t :time)
        {
            if(t%60==0)
                ans+=count[0];
            else
                ans = ans + count[60-t%60];
            
            count[t%60]+=1;
        }
        return ans;
    }
}
