class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int i = 0 ; i  < t.length() ; ++i)
        {
            char ch = t.charAt(i);
            if(tmap.containsKey(ch))
            {
                tmap.put(ch,tmap.get(ch)+1);
            }
            else
            {
                tmap.put(ch,1);
            }
        }
        int i = 0; 
        int j =0;

        String ans = "";
        int min_size = Integer.MAX_VALUE;
        HashMap<Character,Integer> smap = new HashMap<>();
        for(int k= 0 ; k < 26; ++k)
        {
            smap.put( (char)('A' + k) , 0);
            smap.put((char)('a' + k) , 0);
        }

        while(j < s.length())
        {
            smap.put(s.charAt(j), smap.get(s.charAt(j)) + 1); 
            
            boolean all_characters_present = true;
            for(char key : tmap.keySet())
            {
                if( tmap.get(key) > smap.get(key))
                {
                    all_characters_present = false;
                    break;
                }
            }

            if(all_characters_present)
            {
                while(i <= j)
                {
                    char ch = s.charAt(i);
                    if(tmap.containsKey(ch))
                    {
                        if(smap.get(ch) -1 < tmap.get(ch))
                        {
                            break;
                        }
                        else
                        {
                            
                            smap.put(ch, smap.get(ch)-1);
                            i+=1;
                        }
                    }
                    else
                    {
                        smap.put(ch, smap.get(ch)-1);
                        i+=1;
                    }
                }

                int current_ans_size = j-i + 1;
                if(current_ans_size < min_size)
                {
                    StringBuilder sb = new StringBuilder();
                    for(int k = i ; k <= j ; ++k)
                        sb.append(s.charAt(k));
                    ans = sb.toString();
                    min_size = current_ans_size;
                }
            }
            j+=1;
        }

        return ans;
    }
}
