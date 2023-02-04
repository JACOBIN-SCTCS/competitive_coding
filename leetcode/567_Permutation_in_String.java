class Solution {

    boolean checkmatch(int[] s1map, int[] s2map)
    {
        for(int i=0;i<s1map.length;++i)
        {
            if(s1map[i]!=s2map[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        
        if(s2.length() < s1.length())
            return false;

        for(int i=0;i<s1.length();++i)
        {
            s1map[s1.charAt(i)-'a'] +=1;
            s2map[s2.charAt(i)-'a'] +=1;
        }
        boolean match = checkmatch(s1map,s2map);
        if(match)
            return true;

        for(int i=1;i<=(s2.length()-s1.length());++i)
        {
            s2map[s2.charAt(i-1)-'a']-=1;
            s2map[s2.charAt(i+s1.length()-1)-'a'] +=1;

            match = checkmatch(s1map,s2map);
            if(match)
                return true;
        }

        return checkmatch(s1map,s2map);
    }
}
