class Solution {
    public String shortestSuperstring(String[] words) 
    {
        int n = words.length;
        int[][] overlap = new int[n][n];
        
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                if(i!=j)
                {
                    int first = words[i].length();
                    int second = words[j].length();
                    
                    int itercount = Math.min(first,second);
                    for(int k=itercount;k>=0;k--)
                    {
                        if(words[i].endsWith(words[j].substring(0,k)))
                        {
                            overlap[i][j]=k;
                            break;
                        }
                    }
                }
            }
        }
        
        
        
        int[][] dp  = new int[1<<n][n];
        int[][] parent = new int[1<<n][n];
        
        for(int mask=0;mask<dp.length;++mask)
        {
            Arrays.fill(parent[mask],-1);
            for(int bit=0;bit<n;++bit)
            {
                if(((mask>>bit)&1) > 0)
                {
                    int pmask = mask^(1<<bit);
                    if(pmask==0)
                        continue;
                    for(int i=0;i<n;++i)
                    {
                        if(((pmask>>i)&1)>0)
                        {
                            int val = dp[pmask][i] + overlap[i][bit];
                            if(val>dp[mask][bit])
                            {
                                dp[mask][bit]=val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
            } 
            
        }
        
        int[] perm = new int[n];
        boolean[] seen = new boolean[n];
        int t=0;
        int mask = (1<<n)-1;
        int p=0;
        
        for(int j=0;j<n;++j)
        {
            if(dp[(1<<n)-1][j] > dp[(1<<n)-1][p])
                p=j;
        }
        
        while(p!=-1)
        {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= (1<<p);
            p=p2;
        }
        for(int i=0;i<t/2;++i)
        {
            int v = perm[i];
            perm[i] = perm[t-1-i];
            perm[t-1-i] = v;
        }
        for(int i=0;i<n;++i)
        {
            if(!seen[i])
                perm[t++]=i;
        }
        StringBuilder ans = new StringBuilder(words[perm[0]]);
        for(int i=1;i<n;++i)
        {
            int o = overlap[perm[i-1]][perm[i]];
            ans.append(words[perm[i]].substring(o));
        }
        return ans.toString();
        
    }
}
