class Solution {
   
    boolean[][] dp;
    boolean[][] visited;
    
    public boolean compute(String s, int sidx, String p, int pidx)
    {
        if(sidx>=s.length() && pidx>=p.length())
            return true;
        else if(sidx<s.length() && pidx>=p.length())
            return false;
        else if(sidx>=s.length() && pidx<p.length())
        {
            int ptr = pidx;
            while(ptr<p.length())
            {
                if(p.charAt(ptr)!='*')
                    return false;
                ptr+=1;
            }
            return true;
        }
        
        if(visited[sidx][pidx]==true)
            return dp[sidx][pidx];
        
        boolean ans = false;
        if(p.charAt(pidx)=='*')
        {
            ans = compute(s,sidx+1,p,pidx) || compute(s,sidx,p,pidx+1);
        }
        else 
        {
            if(p.charAt(pidx)=='?' || s.charAt(sidx)==p.charAt(pidx))
            {
                ans = true && compute(s,sidx+1,p,pidx+1);
            }
            else
            {
                if(s.charAt(sidx)!=p.charAt(pidx))
                    ans= false;
            }
        }
        visited[sidx][pidx]=true;
        dp[sidx][pidx] = ans;
        return dp[sidx][pidx];
        
    }
    
    public boolean isMatch(String s, String p) 
    {
        dp = new boolean[s.length()][p.length()];
        visited = new boolean[s.length()][p.length()];
        
        for(boolean[] row:dp)
            Arrays.fill(row,false);
        for(boolean[] row: visited)
            Arrays.fill(row,false);
  
        return compute(s,0,p,0);    
    }
}
