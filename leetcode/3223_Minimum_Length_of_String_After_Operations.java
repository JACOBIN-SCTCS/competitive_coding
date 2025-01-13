class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for(int i=0; i < s.length(); ++i)
            count[s.charAt(i)-'a'] += 1;

        int ans = 0;
        for(int i=0; i < 26 ; ++i)
        {
            if(count[i] >= 3)
            {
                if(count[i]%2 == 0)
                    ans = ans + 2;
                else
                    ans+=1;
            }
            else
                ans += count[i];
        }
        return ans;
    }
}
