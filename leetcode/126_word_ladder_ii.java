class Solution {
    
    HashMap<String,List<String>> adj_list = new HashMap<>();
    List<String> path = new ArrayList<String>();
    List<List<String>> ret_list = new ArrayList<List<String>>();
    HashSet<String> dict = new HashSet<String>();
    
    
    public List<String> nextlist(String current)
    {
        List<String> list = new ArrayList<String>();
        char[] characters = current.toCharArray();
        for(int i=0;i<characters.length;++i)
        {
            char current_character= characters[i];
            for(char ch='a' ; ch<='z' ; ++ch)
            {
                characters[i] = ch;
                if(ch==current_character || !dict.contains(String.valueOf(characters)))
                {
                    continue;
                }
                list.add(String.valueOf(characters));
            }
            characters[i] = current_character;
        }
        return list;
    }
    
    
    public void bfs(String begin)
    {
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(begin); visited.add(begin);
        
        while(!q.isEmpty())
        {
            List<String> currentlist = new ArrayList<String>();
            int size = q.size();
            for(int i=0;i<size;++i)
            {
                String now = q.poll();
                List<String> neighbours = nextlist(now);
                for(int j=0;j<neighbours.size();++j)
                {
                    String neighbour = neighbours.get(j);
                    currentlist.add(neighbour);
                    
                    if(!adj_list.containsKey(now))
                        adj_list.put(now,new ArrayList<String>());
                    adj_list.get(now).add(neighbour);
                    if(!visited.contains(neighbour))
                    {
                        q.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            for(String word:currentlist)
            {
                if(dict.contains(word))
                    dict.remove(word);
            }
                
        }
    }
    
    public void dfs(String start, String end)
    {
        if(start.equals(end))
        {
            ret_list.add(new ArrayList<String>(path));
            return;
            
        }
        if(!adj_list.containsKey(start))
            return;
        
        List<String> neighbours = adj_list.get(start);
        for(int i=0;i<neighbours.size();++i)
        {
            String next = neighbours.get(i);
            path.add(next);
            dfs(next,end);
            path.remove(path.size()-1);
        }
            
    }
    
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return ret_list;
        if(dict.contains(beginWord))
            dict.remove(beginWord);
        
        bfs(beginWord);
        path.add(beginWord);
        dfs(beginWord,endWord);
        return ret_list;
        
        
    }
}
