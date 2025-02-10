class Solution {
    public String clearDigits(String s) {
        
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i < s.length(); ++i)
        {
            if(s.charAt(i)>= 'a' && s.charAt(i) <= 'z')
                st.push(s.charAt(i));
            else
            {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0,st.peek());
            st.pop();
        }
        return sb.toString();


    }
}
