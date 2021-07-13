class Solution {
    public int minSpeedOnTime(int[] dist, double hour)
    {
        int min = 1;
        int max = 1000000000;
        int ans  = -1;
        while(min<max)
        {
            int mid = (min+max)/2;
            double time = 0.0;
            for(int i=0;i<dist.length-1;i++)
            {
                time = time + Math.ceil( ( (double) dist[i]) /mid);
            }
            time = time + ((double)dist[dist.length-1])/mid;
            if(time<=hour)
            {
                max = mid;
                ans = mid;
            }
            else
            {
                min = mid+1;
            }
        }
        return ans;
    }
}
