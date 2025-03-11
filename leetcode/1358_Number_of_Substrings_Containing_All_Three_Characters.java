class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
    
        int end = 0;
        int start = 0;
        int ans = 0;

        while(end < s.length())
        {
            count[s.charAt(end)-'a'] += 1;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0)
            {
                ans = ans + (s.length() - end);
                count[s.charAt(start)-'a'] -=1;
                start+=1;
               
            }
            end+=1;
        }
        return ans;
    }
}
