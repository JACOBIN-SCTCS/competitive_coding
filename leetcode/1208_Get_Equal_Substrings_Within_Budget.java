class Solution {
    public int equalSubstring(String s, String t, int maxCost) 
    {
        int[] difference = new int[s.length()];
        for(int i=0; i < s.length(); ++i)
        {
            difference[i] = Math.abs((int)(s.charAt(i) - t.charAt(i)));
        }

        int running_sum = 0;
        int left =0 ;
        int right =0 ;
        int ans =0;

        while(right < s.length())
        {
            running_sum += difference[right];
            while(left< right && running_sum > maxCost)
            {
                running_sum -= difference[left];
                left+=1;
            }
            if(running_sum <= maxCost)
            {
                ans = Math.max(ans,right-left+1);
            }
            right+=1;
        }


        return ans;

    }
}
