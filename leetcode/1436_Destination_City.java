class Solution {
    public String destCity(List<List<String>> paths) 
    {
        HashSet<String> outgoing = new HashSet<>();
        
        for(int i =0 ;i<paths.size();++i)
        {
            outgoing.add(paths.get(i).get(0));
        }

        for(int i =0 ;i<paths.size();++i)
        {
            if(!outgoing.contains(paths.get(i).get(1)))
                return paths.get(i).get(1);
           
        }
        return "";
    }
}
