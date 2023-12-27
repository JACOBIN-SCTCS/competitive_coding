class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int ans = 0;
        char currentColor = colors.charAt(0);
        int currentBalloon = 0;

        for(int i=1; i < colors.length(); ++i)
        {
            if(currentColor != colors.charAt(i))
            {
                currentBalloon = i;
                currentColor = colors.charAt(i);
            }
            else
            {
                if(neededTime[i]  > neededTime[currentBalloon])
                {
                    ans = ans + neededTime[currentBalloon];
                    currentBalloon = i;
                }
                else
                {
                    ans = ans + neededTime[i];
                }
            }

        }
        return ans;
    }   
}
