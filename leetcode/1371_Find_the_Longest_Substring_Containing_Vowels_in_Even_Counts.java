class Solution {
    public int findTheLongestSubstring(String s) {
    
        // state space
        int[] firstoccurence = new int[32];
        Arrays.fill(firstoccurence,-1);

        int ans = 0;

        int mask = 0;
        for(int i=0; i < s.length(); ++i)
        {
            if(s.charAt(i) == 'a')
            {
                mask = mask ^ 1;
            }
            else if(s.charAt(i) == 'e')
            {
                mask = mask ^ 2;
            }
            else if(s.charAt(i) == 'i')
            {
                mask = mask ^ 4;
            }
            else if(s.charAt(i) == 'o')
            {
                mask = mask ^ 8;
            }
            else if(s.charAt(i) == 'u')
            {
                mask = mask ^ 16;
            }

            if(firstoccurence[mask] == -1 && mask != 0)
            {
                firstoccurence[mask] = i;
            }

            ans = Math.max(ans, i-firstoccurence[mask]);

        }
        return ans;
    }
}
