class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); ++i)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int odd_count = 0;
        int ans = 0;
        for(char key : map.keySet())
        {
            int count = map.get(key);
            odd_count = (odd_count + (count%2));
            ans = ans + ((count/2)*2);
        }
    
        ans = ans + Math.min(1,odd_count);
        return ans;

    }
}
