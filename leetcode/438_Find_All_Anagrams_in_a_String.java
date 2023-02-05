class Solution {
    
    boolean match(int[] schars , int[] pchars)
    {
        for(int i=0;i<26;++i)
        {
            if(schars[i]!=pchars[i])
                return false;
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> ans = new ArrayList<Integer>();
        if(p.length() > s.length())
            return ans;

        int[] pchars = new int[26];
        int[] schars = new int[26];

        for(int i=0;i<p.length();++i)
        {
            pchars[p.charAt(i)-'a'] +=1;
            schars[s.charAt(i)-'a'] +=1; 
        }    
        if(match(schars,pchars))   
            ans.add(0);
        for(int i=1;i<=(s.length()-p.length());++i)
        {
            schars[s.charAt(i-1)-'a']-=1;
            schars[s.charAt(i+p.length()-1)-'a']+=1;
            if(match(schars,pchars))
                ans.add(i);
        }



        return ans; 
    }
}
