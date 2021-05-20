class Solution {
    
    public int DFS(String word, HashSet<String> dict, HashMap<String,Integer> map)
    {
        if(map.containsKey(word))
            return map.get(word);
        StringBuilder sb = new StringBuilder(word);
        int  ans = 1;
        for(int i=0;i<word.length();++i)
        {
            sb.deleteCharAt(i);
            String curr = sb.toString();
            if(dict.contains(curr))
            {
                int  current = 1 + DFS(curr,dict,map);
                ans = Math.max(current,ans);
            }
            sb.insert(i,word.charAt(i));
        }
        map.put(word,ans);
       return map.get(word);
    }
    
    
    public int longestStrChain(String[] words) {
        HashSet<String> dict = new HashSet<String>();
        for(String word:words)
            dict.add(word);
        
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int max_length = Integer.MIN_VALUE;
        for(String word: words)
        {
            int length = DFS(word,dict,map);
            max_length = Math.max(max_length,length);
        }
        return max_length;
            
    }
}
