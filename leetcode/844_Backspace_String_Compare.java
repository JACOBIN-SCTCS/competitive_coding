class Solution {
    
    public String processtext(String s)
    {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='#')
            {
                if(st.size() > 0)
                {
                    st.pop();
                }   
            }
            else
            {
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            char current  = st.peek();
            sb.append(current);
            st.pop();
        }
        return sb.toString();
    }
    
    
    
    public boolean backspaceCompare(String s, String t) {
       String s1 = processtext(s);
       String s2 = processtext(t);

       return s1.equals(s2);
    }
}
