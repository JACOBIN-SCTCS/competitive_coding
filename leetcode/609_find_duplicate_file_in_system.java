class Solution {
    public List<List<String>> findDuplicate(String[] paths) 
    {
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String path:paths)
        {
            String[] entries = path.split(" ");
            for(int i=1;i<entries.length;++i)
            {
                String[] contents = entries[i].split("\\(");
                String content = contents[1].replace(")","");
                if(map.containsKey(content))
                {
                    List<String> list = map.get(content);
                    list.add(entries[0]+"/"+contents[0]);
                    map.put(content, list);
                }
                else
                {
                    List<String> list = new ArrayList<String>();
                    list.add(entries[0]+"/"+contents[0]);
                    map.put(content,list);
                }
                
            }
        }
        List<List<String>> ret_list = new ArrayList<List<String>>();
        for(String key:map.keySet())
        {
            if(map.get(key).size()>1)
                ret_list.add(map.get(key));
        }
        return ret_list;
    }
}
