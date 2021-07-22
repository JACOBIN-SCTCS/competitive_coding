class Solution {
        
    HashMap<Long,Integer> dp = new HashMap<>();
    
    public int compute(long n)
    {
        if(dp.containsKey(n))
            return dp.get(n);
        
        if(n==1)
            return 0;
      
        int res;
        if(n%2==0)
        {
            res = compute(n/2);
            res+=1;
            dp.put(n,res);
        }
        else
        {
            int res1 = compute(n-1);
            int res2 = compute(n+1);
            res = Math.min(res1,res2)+1;
            dp.put(n,res);
        }
        return res;
    }
    
    public int integerReplacement(int n) {
        return compute((long)n);
        
    }
}
