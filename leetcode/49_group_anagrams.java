class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs)
        {
            char[] strarray = s.toCharArray();
            Arrays.sort(strarray);
            
            StringBuilder builder = new StringBuilder();
            for(char ch:strarray)
                builder.append(ch);
            
            
            String sorted = builder.toString();
            if(!map.containsKey(sorted))
            {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(sorted, list);
            
            }
            else
            {
                List<String> list = map.get(sorted);
                list.add(s);
                map.put(sorted,list);
            }
        }
        
        List<List<String>> ret_list = new ArrayList<List<String>>();
        for(String str: map.keySet())
        {
            ret_list.add(map.get(str));
        }
        
        return ret_list;
    }
}
