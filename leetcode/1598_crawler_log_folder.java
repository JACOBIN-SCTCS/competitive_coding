class Solution {
    public int minOperations(String[] logs)
    {
        Stack<String> st = new Stack<>();
        for(String log:logs)
        {
            String[] paths = log.split("/");
            for(String path:paths)
            {
                if(path.equals("."))
                    continue;
                else if(path.equals(".."))
                {
                    if(!st.isEmpty())
                    {
                        st.pop();
                    }
                }
                else
                {
                    st.push(path);
                }
            }
        }
        return st.size();
        
    }
}
