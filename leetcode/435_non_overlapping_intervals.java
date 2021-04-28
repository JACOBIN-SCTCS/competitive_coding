
class CustomComparator implements Comparator<int[]>
{
    @Override
    public int compare( int[] a , int []b)
    {
        if(a[1]!=b[1])
            return a[1]-b[1];
        else
            return a[0]-b[0];
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, new CustomComparator());
        int prev=0;
        int ans=0;
        
        for(int i=1;i<intervals.length;++i)
        {
            if(intervals[i][0]>= intervals[prev][1])
            {
                prev=i;
            }
            else
            {
                ans+=1;
            }
        }
        return ans;
    }
}
