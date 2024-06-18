
class Job
{
    int profit;
    int difficulty;

    Job(int profit, int difficulty)
    {
        this.profit = profit;
        this.difficulty = difficulty;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int ans = 0;
        
        
        Job[] jobs = new Job[difficulty.length+1];
        for(int i=0; i < difficulty.length; ++i)
        {
            jobs[i] = new Job(profit[i],difficulty[i]);
        }
        jobs[difficulty.length] = new Job(0,0);
        
        Arrays.sort(jobs, new Comparator<Job>(){
            public int compare(Job a, Job b)
            {
               return a.difficulty - b.difficulty;
            }
        });
        
        int[] max_so_far = new int[jobs.length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i < jobs.length;++i)
        {
            max = Math.max(max,jobs[i].profit);
            max_so_far[i] = max;
        }

        for(int i=0; i < worker.length;++i)
        {
            int ability = worker[i];
            int l =0; 
            int r = jobs.length-1;
            int jobProfit=0;

            while(l <= r)
            {
                int mid = (r+l)/2;
                if(jobs[mid].difficulty <= ability)
                {
                    jobProfit = Math.max(jobProfit,max_so_far[mid]);
                    l = mid+1;
                }
                else
                {
                    r = mid-1;
                }
            }
            ans = ans + jobProfit;
            
        }

        return ans;
    }
}
