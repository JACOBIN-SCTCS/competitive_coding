class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) 
    {
        if(timeSeries.length==0)
            return 0;
        
        int total = 0;
        int n = timeSeries.length;
        for(int i=0;i<n-1;++i)
        {
            total+= Math.min(timeSeries[i+1]-timeSeries[i],duration);
        }
        return total+duration;
    }
}
