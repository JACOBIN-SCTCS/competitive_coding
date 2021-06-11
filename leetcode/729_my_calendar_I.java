class MyCalendar {

  
    List<int[]> intervals ;
    
    public MyCalendar() 
    {
        this.intervals =  new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) 
    {
        for(int i=0;i<intervals.size();++i)
        {
            int[] interval = intervals.get(i);
            if(interval[1]>start && end>interval[0])
                return false;
        }
        intervals.add(new int[]{start,end});
        return true;
            
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
