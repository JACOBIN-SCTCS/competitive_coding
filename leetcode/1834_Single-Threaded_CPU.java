
class Solution {

    class Task
    {
        int index;
        int[] task;

        Task(int index , int[] task)
        {
            this.index = index;
            this.task = task;
        }
    }    


    class TaskComparator implements Comparator<Task> {

        public int compare(Task t1 , Task t2)
        {
            if(t1.task[1] < t2.task[1])
                return -1;
            else if(t1.task[1] > t2.task[1])
                return 1;
            else
                return (t1.index-t2.index);

        }
    }  

    class TaskSorter implements Comparator<Task> {
        public int compare(Task t1 , Task t2)
        {
            return (t1.task[0] - t2.task[0]);
        }
    }
    
    public int[] getOrder(int[][] tasks) 
    {
        PriorityQueue<Task> pq = new PriorityQueue<Task>(5,new TaskComparator());
        int[] order = new int[tasks.length];

        List<Task> tasklist = new ArrayList<Task>();
        for(int i=0;i<tasks.length;++i)
            tasklist.add(new Task(i,tasks[i]));
        
        Collections.sort(tasklist,new TaskSorter());

        int taskidx = 0;
        int time = tasklist.get(0).task[0];
        int orderidx = 0;

        while(taskidx < tasklist.size() || !pq.isEmpty())
        {

            if(pq.isEmpty() && (time <= tasklist.get(taskidx).task[0]))
            {
                if(taskidx < tasklist.size())
                {
                    time = tasklist.get(taskidx).task[0];
                }
            }

            while( taskidx < tasklist.size() && time >= tasklist.get(taskidx).task[0]  )
            {

                Task current_task = tasklist.get(taskidx);
                pq.add(current_task);
                taskidx += 1;
            }
            if(!pq.isEmpty())
            {
                Task current_task = pq.poll();
                time = time + current_task.task[1];
                order[orderidx++] = current_task.index;
            }
        }

        return order;

    }
}
