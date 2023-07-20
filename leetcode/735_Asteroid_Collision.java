class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        Stack<Integer> st = new Stack<Integer>();
        st.push(asteroids[0]);
        for(int i=1;i<asteroids.length;++i)
        {
            int current_sign = (asteroids[i]<0) ? -1 : 1;
            int top_sign;
            boolean equal = false;

            while(!st.isEmpty())
            {
                top_sign = (st.peek() < 0) ? -1 : 1;
                if(top_sign != current_sign)
                {
                    if(top_sign == -1  && current_sign == 1)
                    {
                        st.push(asteroids[i]);
                        break;
                    }
                    else if(Math.abs(asteroids[i]) == Math.abs(st.peek()))
                    {
                        int removed = st.pop();
                        equal = true;
                        break;

                    }
                    else if(Math.abs(asteroids[i]) < Math.abs(st.peek()))
                    {
                        break;
                    }
                    else
                    {
                       int removed =  st.pop();
                    }
                }
                else
                {
                    st.push(asteroids[i]);
                    break;
                }
            }
            if(st.isEmpty() && !equal)
            {
                st.push(asteroids[i]);
            }
        }
        int[] ans = new int[st.size()];
        if(st.size() ==0)
        {
            return ans;
        }
        for(int i = 0; i<ans.length;++i)
        {
            ans[(ans.length-1)-i] = st.pop();
        }
        return ans;
    }
}
