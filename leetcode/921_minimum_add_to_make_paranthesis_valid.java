class Solution {
    public int minAddToMakeValid(String s) 
    {
        Stack<Character> st = new Stack<Character>();
        int ans=0;
        
        for(int i=0;i<s.length();++i)
        {
            if(s.charAt(i)=='(')
            {
                st.push('(');
            }
            else if(s.charAt(i)==')')
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
                else
                {
                    ans+=1;
                }
                    
            }
        }
        return ans + st.size();
    }
}
