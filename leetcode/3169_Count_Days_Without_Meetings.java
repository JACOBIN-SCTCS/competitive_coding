class Solution {
    public int countDays(int days, int[][] meetings) {

        int ans = 0;

        Arrays.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                {
                    return b[1] - a[1];
                }
                else
                {
                    return a[0] - b[0];
                }
            }
        });
        int end = 0;
        int idx = 0;
        while(end <=days)
        {
            if(idx >= meetings.length )
                break;
            
            if(meetings[idx][0] > end)
            {
                ans = ans + (meetings[idx][0]-end-1);
                end = meetings[idx][1];
                idx+=1;
            }
            else
            {
                end = Math.max(end, meetings[idx][1]);
                idx+=1;
            }
            
        }
        if(end <= days)
            ans = ans + (days-end);

        return ans;

    }
}
