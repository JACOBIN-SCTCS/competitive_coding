class Solution {
    public int appendCharacters(String s, String t) {
        
        int sptr = 0;
        int tptr = 0;
        int ans = 0;

        while(sptr < s.length())
        {
            if( tptr < t.length() && s.charAt(sptr) == t.charAt(tptr))
                tptr+=1;
            sptr+=1;
        }
        return (t.length() - tptr);
        
    }
}
