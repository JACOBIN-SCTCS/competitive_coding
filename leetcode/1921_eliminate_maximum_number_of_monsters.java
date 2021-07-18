class Solution {
    public int eliminateMaximum(int[] dist, int[] speed)
    {
        int count = 0 ;
        double[] time = new double[dist.length];
        
        for(int i=0;i<dist.length;++i)
        {
            time[i] = ((double)dist[i])/speed[i];
        }
        
        Arrays.sort(time);
        int curr = 0;
        while(curr<speed.length)
        {
            if((time[curr]-curr)> 0)
            {
                count+=1;
                curr+=1;
            }
            else
            {
                break;
            }
            
        }
        return count;
    }
}s
