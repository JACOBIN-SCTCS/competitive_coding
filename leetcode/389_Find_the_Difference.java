class Solution {
    public char findTheDifference(String s, String t) 
    {
        int[] mask1 = new int[26];
        int[] mask2 = new int[26];

        for(int i=0;i<s.length();++i)
            mask1[s.charAt(i)-'a'] +=1;
        
        for(int i=0;i<t.length();++i)
            mask2[t.charAt(i)-'a'] +=1;

        for(int i=0;i<26;++i)
        {
            if(mask1[i] != mask2[i])
            {
                return (char)('a'+i);
            }
        }
        return 'a';
    }
}
