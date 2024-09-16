class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int[] minutes = new int[timePoints.size()];

        for(int i=0; i < timePoints.size(); ++i)
        {
            String time = timePoints.get(i);

            int min = ((time.charAt(0)-'0')*10 + time.charAt(1)-'0' )*60 + ((time.charAt(3)-'0')*10 + time.charAt(4)-'0');
            minutes[i] = min;

        }

        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;

        for(int i=1 ; i < minutes.length; ++i)
        {
            ans = Math.min(ans, minutes[i] - minutes[i-1]);
        }
        ans = Math.min(ans ,  (24*60) - (minutes[minutes.length-1] - minutes[0]));
        return ans;
    }
}
