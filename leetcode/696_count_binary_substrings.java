class Solution 
{
    public int countBinarySubstrings(String s) 
    {
        int[] groups = new int[s.length()];
        Arrays.fill(groups,0);
        int idx=0;
        groups[0]=1;
        
        for(int i=1;i<s.length();++i)
        {
            if(s.charAt(i-1)==s.charAt(i))
            {
                groups[idx]+=1;
            }
            else
            {
                idx+=1;
                groups[idx]+=1;
            }
        }
        
        int ans =0 ;
        for(int i=1;i<=idx;++i)
        {
            ans += Math.min(groups[i-1],groups[i]);
        }
        return ans;
    }
}
