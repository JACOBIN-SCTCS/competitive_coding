class Solution {
    public int partitionString(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        int ans = 0;

        for(int i=0;i<s.length();++i)
        {
            char curr = s.charAt(i);
            if(set.contains(curr))
            {
                set.clear();
                ans +=1;
            }
            set.add(curr);
        }    
        if(set.size()>0)
            ans+=1;
        return ans;
    }
}
