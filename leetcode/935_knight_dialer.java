class Solution {
    
    
    HashMap<Integer,List<Integer>> movemap = new HashMap<Integer,List<Integer>>();
  
    public void populatemap()
    {
        for(int i=0;i<10;++i)
            movemap.put(i,new ArrayList<Integer>());
        
        movemap.get(0).add(4); movemap.get(0).add(6);
        movemap.get(1).add(6); movemap.get(1).add(8);
        movemap.get(2).add(7); movemap.get(2).add(9);
        movemap.get(3).add(4); movemap.get(3).add(8);

        movemap.get(4).add(3); movemap.get(4).add(9);  movemap.get(4).add(0);
        movemap.get(6).add(1); movemap.get(6).add(7);  movemap.get(6).add(0);


        movemap.get(7).add(2); movemap.get(7).add(6);
        movemap.get(8).add(1); movemap.get(8).add(3);
        movemap.get(9).add(4); movemap.get(9).add(2);

        
    }
    


    
    public int knightDialer(int n) 
    {
       
        populatemap();
        
        long[][] dp = new long[n+1][10];
        long mod = 1000000007;

        for(int i=0;i<10;++i)
            dp[1][i] = 1l;
        
        for(int i=2;i<=n;++i)
        {
            for(int j=0;j<10;++j)
            {
                List<Integer> moves = movemap.get(j);
                for(int k=0;k<moves.size();++k)
                {
                    dp[i][j] = (dp[i][j] +  dp[i-1][moves.get(k)])%mod;
                }
            }
        }
        long ans = 0l;
        for(int j=0;j<10;++j)
        {
            ans = (ans+dp[n][j])%mod;
        }
        
        return (int)ans;
    }
}
