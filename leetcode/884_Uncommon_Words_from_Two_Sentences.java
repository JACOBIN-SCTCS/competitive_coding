class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        
        Map<String,Integer> map = new HashMap<>();
        List<String> ans_list = new ArrayList<String>();

        for(String word : s1.split(" "))
        {
           map.put(word,map.getOrDefault(word,0) + 1);
        }

        for(String word : s2.split(" "))
        {
            map.put(word,map.getOrDefault(word,0) + 1);
        }

        for(String key : map.keySet())
        {
            if(map.get(key) == 1)
                ans_list.add(key);
        }

        return ans_list.toArray(new String[ans_list.size()]);
    }
}
