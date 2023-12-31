class Solution {
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        ArrayList<Integer>[] hashtable = new ArrayList[26];
        for(int i = 0 ; i < hashtable.length; ++i)
            hashtable[i] = new ArrayList<Integer>();
        
        int ans = -1;
        for(int i=0; i < s.length(); ++i)
        {
            int character = s.charAt(i) - 'a';
            for(int j=0; j < hashtable[character].size(); ++j)
            {
                ans = Math.max(ans,(i - hashtable[character].get(j) -1));
            }

            hashtable[character].add(i);
        }
        return ans;
    }
}
