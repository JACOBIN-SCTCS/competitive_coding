class Solution {
    public String makeGood(String s) 
    {
        Stack<Character> st = new Stack<>();
        for(int i = s.length()-1 ; i >= 0; i-- )
        {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
            {
             
                if(!st.isEmpty() && (st.peek() == Character.toUpperCase(s.charAt(i))))
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
            else
            {
                if(!st.isEmpty() && (st.peek() == Character.toLowerCase(s.charAt(i))))
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
               
        }    
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }
        return sb.toString();
            
    }
}
