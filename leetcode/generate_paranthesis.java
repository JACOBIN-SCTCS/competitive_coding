class Solution 
{
    List<String> list = new ArrayList<String>();

    public void createString(int n , int open ,  int close ,  String sol)
    {
        if(open==n && close==n)
        {
            list.add(sol);
            return;
            
        }
        else
        {
            if(open>close)
            {
                String possible = sol + ")";
                createString(n,open,close+1,possible);
            }
            
            if(open<n)
            {
                String possible = sol +"(";
                createString(n,open+1,close,possible);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) 
    {
        createString(n,0,0,new String(""));
        return list;
    }
}
