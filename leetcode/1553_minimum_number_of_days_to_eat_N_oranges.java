class Solution {
    
    HashMap<Integer,Integer> dp ;
    
    public int compute(int n)
    {
        if(n<=1)
            return n;
        if(dp.containsKey(n))
            return dp.get(n);
        
        int ans = 1+Math.min(n%2+compute(n/2) , n%3 + compute(n/3));
        dp.put(n,ans);
        return ans;
        
    }
    
    public int minDays(int n) 
    {
        dp = new HashMap<Integer,Integer>();
        return compute(n);
    }
}
