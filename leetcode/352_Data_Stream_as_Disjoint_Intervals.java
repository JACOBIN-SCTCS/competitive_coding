class SummaryRanges 
{

    TreeSet<Integer> ts;

    public SummaryRanges() 
    {
        ts = new TreeSet<Integer>();
    }
    
    public void addNum(int value) {
        ts.add(value);
    }
    
    public int[][] getIntervals() {
        List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        Iterator<Integer> iterate = ts.iterator();
        while(iterate.hasNext())
        {
            int curr_element = iterate.next();
            if(list.size()==0)
            {
                ArrayList<Integer> curr_list = new ArrayList<Integer>();
                curr_list.add(curr_element);
                curr_list.add(curr_element);
                list.add(curr_list);
            }
            else
            {
                int upper_bound = list.get(list.size()-1).get(1);
                if(curr_element == (upper_bound+1))
                {
                    list.get(list.size()-1).set(1,curr_element);
                }
                else
                {
                    ArrayList<Integer> curr_list = new ArrayList<Integer>();
                    curr_list.add(curr_element);
                    curr_list.add(curr_element);
                    list.add(curr_list);
                }
            }
        }

        int[][] ret_array = new int[list.size()][2];
        for(int i=0;i<list.size();++i)
        {
            ret_array[i][0] = list.get(i).get(0);
            ret_array[i][1] = list.get(i).get(1);
        }
        return ret_array;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
