class Solution 
{

    public int scheduleCourse(int[][] courses)
    {
        if (courses.length == 0 || courses == null)
            return 0;
        
        Arrays.sort(courses, (a,b)-> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(courses.length,Collections.reverseOrder());
        int time=0;
        for(int[] course:courses)
        {
           time+=course[0];
            pq.add(course[0]);
            if(time> course[1])
                time-= pq.poll();
        }
        return pq.size();
    }
}
