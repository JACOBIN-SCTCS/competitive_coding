class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1 , int[] o2)
            {
                if(o1[0]!= o2[0])
                {
                    return Integer.compare(o1[0],o2[0]);
                }
                else
                {
                    return Integer.compare(o1[1],o2[1]);
                }
            }
            
        });
        
        
        ArrayList<int[]> pairs = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        pairs.add(intervals[0]);
        for(int i=1;i<intervals.length;++i)
        {
            if(pairs.get(pairs.size()-1)[1] >= intervals[i][0])
            {
                pairs.get(pairs.size()-1)[1] = Math.max(pairs.get(pairs.size()-1)[1],
                                                        intervals[i][1]
                                                       );
            }
            else
            {
                pairs.add(intervals[i]);
            }
        }
        
        return pairs.toArray(new int[0][]);
      
        
    }
}
