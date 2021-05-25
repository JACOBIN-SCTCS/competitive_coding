class Solution {
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<tokens.length;++i)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))
            {
                int first = st.peek();
                st.pop();
                int second = st.peek();
                st.pop();
                
                if(tokens[i].equals("+"))
                    second = first + second;
                else if(tokens[i].equals("-"))
                    second = second- first;
                else if(tokens[i].equals("*"))
                    second = second*first;
                else
                    second = second/first;
                    
                st.push(second);
            }
            else
            {
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }
        return st.peek();
        
    }
}
