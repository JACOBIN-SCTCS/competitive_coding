class Solution {
    
    List<String> generateList(String s, int i, int j)
    {
       List<String> ans = new ArrayList();
        for (int d = 1; d <= j-i; ++d) {
            String left = s.substring(i, i+d);
            String right = s.substring(i+d, j);
            if ((!left.startsWith("0") || left.equals("0"))
                    && !right.endsWith("0"))
                ans.add(left + (d < j-i ? "." : "") + right);
        }
        return ans;
        
    }
    
    
    public List<String> ambiguousCoordinates(String S) 
    {
        List<String> ans = new ArrayList<String>();
        for(int i=2;i<S.length()-1; ++i)
        {
            for(String left: generateList(S,1,i))
            {
               
                for(String right: generateList(S,i,S.length()-1))
                {
                    ans.add("(" + left +", "+right+")");
                }
            }
        }
        return ans;
        
    }
}
