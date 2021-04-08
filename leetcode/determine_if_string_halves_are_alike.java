class Solution {
    public boolean halvesAreAlike(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        
        int acount=0;
        int bcount=0;
        
        for(int i=0;i<(s.length()/2);++i)
        {
            if(set.contains(s.charAt(i)))
                acount+=1;
        }
        for(int i=(s.length()/2);i<s.length();++i)
        {
            if(set.contains(s.charAt(i)))
                bcount+=1;
        }
        
        if(acount==bcount)
            return true;
        
        return false;
        
    }
}
