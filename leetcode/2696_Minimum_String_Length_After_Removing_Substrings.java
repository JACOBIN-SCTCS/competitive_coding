class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i < s.length(); ++i)
        {
            char current = s.charAt(i);
            if(st.size() > 0)
            {
                if((current == 'D' && st.peek() == 'C') || (current == 'B' && st.peek() == 'A'))
                {
                    st.pop();
                }
                else
                {
                    st.push(current);
                }
            }
            else
            {
                st.push(current);
            }
            
        }

        return st.size();
        
    }
}
