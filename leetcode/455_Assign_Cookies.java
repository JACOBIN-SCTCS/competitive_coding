class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int cookieidx = 0;

        for(int i = 0 ; i < g.length; ++i)
        {
            if(cookieidx >= s.length)
                break;
            while(cookieidx < s.length && s[cookieidx] < g[i])
            {
                cookieidx+=1;
            }
            if(cookieidx < s.length)
            {
                cookieidx +=1;
                ans +=1;
            }
                
        }


        return ans;

    }
}
