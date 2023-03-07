class Solution {
    public long minimumTime(int[] time, int totalTrips) 
    {
        int max_time = 0;
        for(int t: time)
        {
            max_time = Math.max(max_time,t);
        }
        
        long  high = (long)max_time*totalTrips;
        long low = 1;
      

        while(low<high)
        {
            long mid = (high+low)/2;
            if(check(mid,time,totalTrips))
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;

    }

    public boolean check(long mid, int[] time, int totalTrips)
    {
            long total = 0;
            for(int t:time)
            {
                long current = mid / t;
                total += current;
            }
            if(total >= totalTrips)
                return true;
            return false;

    }
}
