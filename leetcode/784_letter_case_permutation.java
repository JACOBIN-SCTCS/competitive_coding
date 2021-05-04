class Solution {
    
    List<String> ret_list = new ArrayList<>();
    
    public void generate(String s, int idx,StringBuilder builder)
    {
        if(idx>=s.length())
        {
            ret_list.add(builder.toString());
            return;
        }
        if(Character.isDigit(s.charAt(idx)))
        {
            builder.append(s.charAt(idx));
            generate(s,idx+1,builder);
            return;
            
        }
        else
        {
            StringBuilder copy1 = new StringBuilder(builder);
            StringBuilder copy2 = new StringBuilder(builder);
            copy1.append(Character.toLowerCase(s.charAt(idx)));
            copy2.append(Character.toUpperCase(s.charAt(idx)));
            generate(s,idx+1,copy1);
            generate(s,idx+1,copy2);
            return;
        }
            
        
    }
    
    public List<String> letterCasePermutation(String S) 
    {
        generate(S,0,new StringBuilder());
        return ret_list;
        
    }
}
