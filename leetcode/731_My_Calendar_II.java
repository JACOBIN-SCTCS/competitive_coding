class MyCalendarTwo {

    List<int[]> intervals; 
    List<int[]> doublyoverlapped;


    public MyCalendarTwo() {
        intervals = new ArrayList<int[]>();
        doublyoverlapped = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int i=0; i < doublyoverlapped.size(); ++i)
        {
            int start_i = doublyoverlapped.get(i)[0];
            int end_i = doublyoverlapped.get(i)[1];
            if(Math.max(start,start_i) < Math.min(end,end_i))
            {
                return false;
            }
        }

        for(int i=0; i < intervals.size(); ++i)
        {
            int start_i = intervals.get(i)[0];
            int end_i = intervals.get(i)[1];
            if(Math.max(start,start_i) < Math.min(end,end_i))
            {
                int[] overlap = new int[2];
                overlap[0] = Math.max(start,start_i);
                overlap[1] = Math.min(end,end_i);
                doublyoverlapped.add(overlap);

            }
        }

        int[] newinterval = new int[2];
        newinterval[0] = start;
        newinterval[1] = end;
        intervals.add(newinterval);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
