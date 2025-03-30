class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int MAX_VAL = 600;

        int[][] intervals = new int[26][2];
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;  i < 26; ++i)
            Arrays.fill(intervals[i],MAX_VAL);

        for(int i= 0; i < s.length(); ++i)
        {
            if(intervals[s.charAt(i)-'a'][0] ==  MAX_VAL)
            {
                intervals[s.charAt(i)-'a'][0] = i;
                intervals[s.charAt(i)-'a'][1] = i;
            }
            else
            {
                intervals[s.charAt(i)-'a'][1] = i;
            }
        }
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override 
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                    return b[1] - a[1];
                else
                    return a[0] -  b[0];
            }
        });

        int idx = 1;

        int start = intervals[0][0];
        int end = intervals[0][1];
        
        while( idx < intervals.length && intervals[idx][0] != MAX_VAL)
        {
            /*System.out.println("Start = " + intervals[idx][0] + " End = " + intervals[idx][1]);
            System.out.println("Start = " + start + " End = " + end);
            System.out.println("-------");*/
            if(intervals[idx][0] > end)
            {
                ans.add(end  - start + 1);
                start = intervals[idx][0];
                end = intervals[idx][1];
            }
            else
            {
                end = Math.max(end, intervals[idx][1]);
            }
            idx+=1;

           
        }

    
        ans.add(end-start+1);

        return ans;
    }
}
