class WordFilter {

    HashMap<String,Integer> map = new HashMap<>();
    public WordFilter(String[] words)
    {
            for(int i=0;i<words.length;++i)
            {
                String curr = words[i];
                List<String> suffix = new ArrayList<String>();
                List<String> prefix = new ArrayList<String>();
                for(int j=0;j<=curr.length();++j)
                {
                    String curr_prefix = curr.substring(0,j);
                    String curr_suffix = curr.substring(j);
                    prefix.add(curr_prefix);
                    suffix.add(curr_suffix);
                }
                
                for(String p:prefix)
                {
                    for(String s:suffix)
                    {
                        String c = p+"#"+s;
                        if(!map.containsKey(c))
                            map.put(c,i);
                        else
                            map.put(c,Math.max(map.get(c),i));
                    }
                }
                
                
                
            }
    }
    
    public int f(String prefix, String suffix) 
    {
        String search = prefix+"#"+suffix;
        if(!map.containsKey(search))
        {
            return -1;
        }
        else
            return map.get(search);
            
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
