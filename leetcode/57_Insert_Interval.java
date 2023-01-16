class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) 
    {
        List<List<Integer>> tmp_list = new ArrayList<List<Integer>>();
        int idx = 0;

        while(idx<intervals.length)
        {
            if(intervals[idx][1]<newInterval[0])
            {
                List<Integer> curr_list = new ArrayList<Integer>();
                curr_list.add(intervals[idx][0]);
                curr_list.add(intervals[idx][1]);
                tmp_list.add(curr_list);
                idx+=1;
            }
            else
            {
                break;
            }
        }
        
        int[] curr_interval = new int[]{newInterval[0],newInterval[1]};
        while(idx<intervals.length)
        {
            if(intervals[idx][0]>newInterval[1])
            {
                break;
            }
            else
            {
                curr_interval[0]  = Math.min(curr_interval[0],intervals[idx][0]);
                curr_interval[1] =  Math.max(curr_interval[1],intervals[idx][1]);
                idx+=1;
            }
        }
        List<Integer> c_list = new ArrayList<Integer>();
        c_list.add(curr_interval[0]);
        c_list.add(curr_interval[1]);
        tmp_list.add(c_list);
        while(idx<intervals.length)
        {
            List<Integer> curr_list = new ArrayList<Integer>();
            curr_list.add(intervals[idx][0]);
            curr_list.add(intervals[idx][1]);
            tmp_list.add(curr_list);
            idx+=1;
        }

        int[][] ret_array = new int[tmp_list.size()][2];
        for(int i =0 ; i<tmp_list.size();++i)
        {
                ret_array[i][0] = tmp_list.get(i).get(0);
                ret_array[i][1] = tmp_list.get(i).get(1);
        
        }
        return ret_array;
    }
}
