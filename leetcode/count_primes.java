class Solution {
    
    
    
    int  util(int n)
    {
        int counter=0;
        BitSet bs = new BitSet(10000000);
        bs.set(0,n+1);
        bs.clear(0);
        bs.clear(1);
        
        for(int i=2;i<=n;++i)
        {
            
            if(bs.get(i))
            {
                
                for(int j=i+i;j<=n;j+=i)
                {
                    bs.clear(j);
                    
                }
            }
        }
       
        for(int i=2;i<n;++i)
        {
            if(bs.get(i))
                counter+=1;
        }
        return counter;
        
    }
    
    public int countPrimes(int n) {
        
        if(n<=2)
            return 0;
         return util(n);
        
    }
}
