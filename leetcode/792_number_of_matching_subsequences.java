class Solution 
{
    public int numMatchingSubseq(String s, String[] words) 
    {
        HashMap<String,Boolean> map = new HashMap<>();
        int count =0;
        for(int i=0;i<words.length;++i)
        {
            if(map.containsKey(words[i]))
            {
                count = (map.get(words[i]))?count+1:count;
                continue;
            }
            
            int ptr =0 ;
            for(int j=0;j<s.length();++j)
            {
                if(ptr>=words[i].length())
                {
                    break;
                }
                
                if(words[i].charAt(ptr)==s.charAt(j))
                {
                    ptr+=1;
                }
                
            }
            
            if(ptr>=words[i].length())
            {
                count+=1;
                map.put(words[i],true);
            }            
            else
            {
                map.put(words[i],false);
            }
        }
        
        return count;
    }
}
