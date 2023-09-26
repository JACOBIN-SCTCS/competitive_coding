class Solution 
{
    public String removeDuplicateLetters(String s) 
    {
        // Had to refer a solution to get the idea of keeping a last index array

        int[] last_idx_arr = new int[26];
        boolean[] already_seen = new boolean[26];
        Arrays.fill(last_idx_arr,-1);
        
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();++i)
        {
            last_idx_arr[s.charAt(i)-'a'] = i;
        }

        for(int i=0;i<s.length();++i)
        {
            char current_char = s.charAt(i);
            int idx = current_char - 'a';
            if(already_seen[idx])
                continue;

            already_seen[idx] = true;
            if(st.isEmpty())
            {
                st.push(current_char);
                continue;
            }
            char st_top = st.peek();
            if(st_top > current_char)
            {
                while(!st.isEmpty() && st_top > current_char)
                {
                    if(last_idx_arr[(int)(st_top - 'a')] > i)
                    {
                        already_seen[st_top-'a'] = false;
                        st.pop(); 
                        if(st.isEmpty())
                            break;
                        st_top = st.peek();
                    }
                    else
                        break;
                  
                }
                st.push(current_char);
            }
            else
            {
                st.push(current_char);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            char current = st.peek();
            st.pop();
            sb.append(current);
        }
        return sb.reverse().toString();
    }
}
