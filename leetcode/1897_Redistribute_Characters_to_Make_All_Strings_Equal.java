class Solution {
    public boolean makeEqual(String[] words) 
    {
        int[] hashtable = new int[26];
        for(String word : words)
        {
            for(int i=0; i < word.length() ;++i)
            {
                hashtable[word.charAt(i)-'a'] +=1;
            }
        }
        for(int i=0; i < 26; ++i)
        {
            if(hashtable[i] % words.length != 0)
                return false;
        } 
        return true;
    }
}
