class Solution {

    int[] cost = new int[2];

    public String processString(String s, int first_char, int second_char, int cost, int iter) 
    {
        Stack<Character> st = new Stack<Character>();
        int ans = 0;
    
        for(int i=0; i < s.length(); ++i)
        {
            char current_character = s.charAt(i);
            if(current_character == second_char) {
                if(st.size() > 0 && st.peek()==first_char)
                {
                    st.pop();
                    ans += cost;
                    
                }
                else 
                {
                    st.push(s.charAt(i));
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        this.cost[iter] = ans;
        
        StringBuilder sb = new StringBuilder();
        while(st.size() > 0)
        {
            sb.append(st.peek());
            st.pop();
        }
        return sb.reverse().toString();
    }

    public int maximumGain(String s, int x, int y) {
        
        int ans = 0;
        if(x > y)
        {
            String s1 = processString(s,'a','b',x , 0);
            String s2 = processString(s1,'b','a',y,1);
        }
        else 
        {
            String s1 = processString(s,'b','a',y , 0);
            String s2 = processString(s1,'a','b',x,1);
        }

        ans = this.cost[0] + this.cost[1];
        return ans;
    }   
}
