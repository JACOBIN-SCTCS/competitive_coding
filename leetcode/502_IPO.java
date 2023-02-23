
class Project implements Comparable<Project>
{
    int profit;
    int capital;

    Project(int profit, int capital)
    {
        this.profit = profit;
        this.capital = capital;
    }
    @Override
    public int compareTo(Project p) 
    {
        return this.capital - p.capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {
       Project[] projects = new Project[profits.length];
       for(int i=0;i<profits.length;++i)
            projects[i] = new Project(profits[i],capital[i]);
        Arrays.sort(projects);
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(profits.length,Collections.reverseOrder());

        int ptr = 0;
        for(int i=0;i<k;++i)
        {
            while(ptr<projects.length && projects[ptr].capital <= w)
            {
                q.add(projects[ptr].profit);
                ptr+=1;
            }

            if(!q.isEmpty())
            {
                w += q.poll();
            }

        }
        return w;
    }
}
