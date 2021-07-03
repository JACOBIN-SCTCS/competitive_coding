class Solution {
    public int minMutation(String start, String end, String[] bank) 
    {
        HashSet<String> dict = new HashSet<>();
        for(int i=0;i<bank.length;++i)
            dict.add(bank[i]);
        
        int layer=0;
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        char[] characters = new char[]{'A','C','G','T'};
        
        if(!dict.contains(end))
            return -1;
        q.add(start);
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size>0)
            {
                String curr = q.poll();
                if(curr.equals(end))
                    return layer;
                
                
                for(int i=0;i<8;++i)
                {
                    StringBuilder sb = new StringBuilder(curr);
                    for(char ch:characters)
                    {
                        sb.setCharAt(i,ch);
                        String next = sb.toString();
                        if(ch!= curr.charAt(i)&&!visited.contains(next) &&  dict.contains(next))
                        {
                            q.add(next);
                        }
                    }
                }
                size-=1;
            }
            layer+=1;
        }
        return -1;
            
    }
}
