class Solution 
{
    public int countStudents(int[] students, int[] sandwiches) 
    {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i < students.length; ++i)
            q.add(students[i]);

        Stack<Integer> st = new Stack<>();
        for(int i= sandwiches.length-1; i>=0 ; i--)
            st.push(sandwiches[i]);
        
        int prev_length = q.size();
        while(!st.isEmpty())
        {
            int length = q.size();
            for(int i=0; i < length; ++i)
            {
                if(q.peek() == st.peek())
                {
                    q.remove();
                    st.pop();
                }
                else
                {
                    int ele = q.poll();
                    q.add(ele);
                }
            }
            if(prev_length == q.size())
                break;
            else
                prev_length = q.size();
        }

        return q.size();
    }
}
