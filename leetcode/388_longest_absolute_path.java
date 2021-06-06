class Solution {
    public int lengthLongestPath(String input) 
    {
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        int max_length =0;
        
        
        for(String file:input.split("\n"))
        {
            String[] height = file.split("\t");
            int level = height.length-1;
            while(level+1<st.size())
            {
                st.pop();
            }
            String curr = height[height.length-1];
            int currlen = st.peek() + curr.length() +1;
            
            if(curr.indexOf('.')!=-1)
            {
                max_length = Math.max(max_length,currlen-1);
            }
            else
            {
                st.push(currlen);
            }
            
        }
        return max_length;
    }
}
