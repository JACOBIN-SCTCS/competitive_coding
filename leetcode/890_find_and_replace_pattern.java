class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        List<String> ret_list= new ArrayList<String>();
        HashMap<Character,Character> front_map = new HashMap<>();
        HashMap<Character,Character> back_map = new HashMap<>();
   
        
        for(int i=0;i<words.length;++i)
        {
            int j=0;
            front_map.clear();
            back_map.clear();
            
            for(j=0;j<pattern.length();++j)
            {
                if(!front_map.containsKey(words[i].charAt(j)))
                    front_map.put(words[i].charAt(j),pattern.charAt(j));
                if(!back_map.containsKey(pattern.charAt(j)))
                    back_map.put(pattern.charAt(j),words[i].charAt(j));
                
                if(front_map.get(words[i].charAt(j))!= pattern.charAt(j)
                   || back_map.get(pattern.charAt(j))!=words[i].charAt(j)
                  )
                    break;
            }
            if(j==pattern.length())
                ret_list.add(words[i]);
            
        }
        return ret_list;
        
    }
}
