class Solution {
    public String removeStars(String s) 
    {
        Stack<Character> st = new Stack<>();
        int i = 0;

        while(i < s.length())
        {
            if(s.charAt(i)=='*')
            {
                if(st.size()>0)
                    st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
            i+=1;
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0)
        {
            char current = st.peek();
            st.pop();
            sb.append(current);
        }    
        StringBuilder sb_reverse = sb.reverse();
        return sb_reverse.toString();
    }
}
