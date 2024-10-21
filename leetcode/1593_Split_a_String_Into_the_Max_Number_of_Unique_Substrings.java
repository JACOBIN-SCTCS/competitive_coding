class Solution {
    
    HashSet<String> seen_strings;
    
    public int helper(String s, int index)
    {
        if(index >= s.length())
            return 0;
        
        int ans = 0;
        for(int i=index; i < s.length() ; ++i)
        {
            String current_string = s.substring(index, i+1);
            if(!seen_strings.contains(current_string))
            {
                seen_strings.add(current_string);
                ans = Math.max(ans , 1 + helper(s,i+1));
                seen_strings.remove(current_string);
            }
        }
        
        return ans;
    }

    public int maxUniqueSplit(String s) 
    {
        seen_strings = new HashSet<String>();
        int ans = helper(s,0);
        return ans;

    }
}
