class Candidate
{
    int eff;
    int speed;
    
    Candidate(int eff, int speed)
    {
        this.eff =eff;
        this.speed = speed;
    }
}

class CandidateComparator implements Comparator<Candidate>
{
    @Override
    public int compare(Candidate e1, Candidate e2)
    {
        return Integer.compare(e2.eff,e1.eff);
    }
}

class Solution {
    
    int mod= 1000000007;
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k)
    {
        Candidate[] candidates = new Candidate[n];
        for(int i=0;i<n;++i)
        {
            candidates[i] = new Candidate(efficiency[i],speed[i]);
        }
        Arrays.sort(candidates,new CandidateComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        long speedsum =0;
        long perf = 0;
        
        
        for(int i=0;i<candidates.length;++i)
        {
            int current_eff = candidates[i].eff;
            int current_speed  = candidates[i].speed;
            
            if(pq.size()>k-1)
            {
                speedsum -= pq.poll();
            }
            pq.add(current_speed);
            speedsum+= current_speed;
            perf = Math.max(perf,speedsum*current_eff);
        }
        return (int)( perf%mod);
        
    }
}
