class Solution {
    public String customSortString(String S, String T) 
    {
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<T.length();++i)
        {
            if(map.containsKey(T.charAt(i)))
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            else
            {
                map.put(T.charAt(i),1);
            }
        }
    
        boolean[] charpresent = new boolean[26];
        Arrays.fill(charpresent,false);
        
        StringBuilder s = new StringBuilder();
        for(int i=0;i<S.length();++i)
        {
            charpresent[S.charAt(i)-'a']=true;
            if(map.containsKey(S.charAt(i)))
            {
                int count=map.get(S.charAt(i));
                while(count>0)
                {
                    s.append(S.charAt(i));
                    count-=1;
                }
            }
        }
        
        for(char character : map.keySet())
        {
            if(!charpresent[character-'a'])
            {
                int count = map.get(character);
                while(count>0)
                {
                    s.append(character);
                    count-=1;
                }
            }
        }
        
        return s.toString();
        
        
        
    }
}
