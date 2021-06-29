class Solution {
    public String removeDuplicates(String s) 
    {
        Stack<Character> st = new Stack<Character>();
        int idx=0;
        while(idx<s.length())
        {
            char current = s.charAt(idx);
            if(!st.isEmpty() && st.peek()==current)
            {
                st.pop();
            }
            else
            {
                st.push(current);
            }
            idx+=1;
        }
        StringBuilder sb  = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.peek());
            st.pop();
        }
        sb  =sb.reverse();
        return sb.toString();
    }
}
