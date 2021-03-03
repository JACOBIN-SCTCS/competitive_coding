class Word
{
    String str;     
    int num;
    Word(String str , int num)
    {
        this.str = str;
        this.num = num;
    }        
}
    


class Solution {
  
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Queue<Word> q = new LinkedList<>();
        Set<String> ss = new HashSet<>(wordList);
        
        q.add(new Word(beginWord , 0));
        
        
        while(!q.isEmpty())
        {
            Word curr = q.remove();
            String str = curr.str;
            if(str.equals(endWord))
            {
                return curr.num+1;
            }
            int num = curr.num;
    
            char ch[]=str.toCharArray();
            
            
            for(int i=0;i<str.length();i++)
            {
                char cha=ch[i];
                for(char c='a';c<='z';c++)
                {
                    if(cha != c)
                    {
                        ch[i] = c;
                        String st = String.valueOf(ch);
                    
                        
                        if(ss.contains(st))
                        {
                            Word mms = new Word(st , num+1);
                            q.add(mms);
                            ss.remove(st);
                        }
                        
                    }
                }
                ch[i] = cha;
            }
        }
        return 0;
    }
}
