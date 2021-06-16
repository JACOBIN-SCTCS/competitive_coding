class Solution {
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> retlist = new ArrayList<List<Integer>>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(int i=0;i<words.length;++i)
            map.put(words[i],i);
        
        for(int i=0;i<words.length;++i)
        {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(reverse))
            {
                if(map.get(reverse)!=i)
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(map.get(reverse));
                    retlist.add(list);
                }
            }
            
            if(map.containsKey("") && map.get("")!=i && new StringBuilder(words[i]).reverse().toString().equals(words[i]))
            {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(map.get(""));
                retlist.add(list);
                list = new ArrayList<Integer>();
                list.add(map.get(""));
                list.add(i);
                retlist.add(list);
            }
            
            
            int cur_reverse =0 ;
            while(cur_reverse<reverse.length()-1)
            {
                if(map.containsKey(reverse.substring(0,cur_reverse+1)))
                {
                    String rem = words[i].substring(0,words[i].length()-cur_reverse-1);
                    if(new StringBuilder(rem).reverse().toString().equals(rem))
                    {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(reverse.substring(0,cur_reverse+1)));
                        list.add(i);
                        retlist.add(list);
                    }
                    
                }
                cur_reverse+=1;
            }
            
            int cur_forward = 0;
            while(cur_forward<words[i].length()-1)
            {
                String rev = new StringBuilder(words[i].substring(0,cur_forward+1)).reverse().toString();
                if(map.containsKey(rev))
                {
                    String rem = words[i].substring(cur_forward+1);
                    if(new StringBuilder(rem).reverse().toString().equals(rem))
                    {
                        List<Integer> list  = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(rev));
                        retlist.add(list);
                    }
                }
                cur_forward+=1;
            }
            
            
        }
           return retlist; 
    }
}
