class Solution 
{
    public int openLock(String[] deadends, String target) 
    {
        HashSet<String> jamset = new HashSet<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String s: deadends)
            jamset.add(s);
        
        String start = new String("0000");
        if(jamset.contains(target) || jamset.contains(start))
            return -1;
        if(start.equals(target))
            return 0;
        
        Queue<String>  q = new LinkedList<String>();
        q.add(start);
        map.put(start,0);
        while(!q.isEmpty())
        {
            String curr =q.remove();
            if(curr.equals(target))
                return map.get(curr);
            char[] characters = curr.toCharArray();
            for(int i=0;i<4;++i)
            {
                char current_ring = characters[i];
                char right_shift = current_ring=='9'?'0':(char)(current_ring+1);
                char left_shift = current_ring=='0'?'9':(char)(current_ring-1);
                
                characters[i] = right_shift;
                String right_string = new String(characters);
                characters[i] = left_shift;
                String left_string  = new String(characters);
                characters[i]= current_ring;
                
                if(!map.containsKey(right_string) && !jamset.contains(right_string))
                {
                    map.put(right_string,map.get(curr)+1);
                    q.add(right_string);
                    
                }
                if(!map.containsKey(left_string) && !jamset.contains(left_string))
                {
                    map.put(left_string,map.get(curr)+1);
                    q.add(left_string);
                    
                }
            }
        }
        return -1;
    }
}
