class Solution {
    public int countPrimes(int n) 
    {
        if(n<2)
            return 0;
            
        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;
        int count=0;
        for(int i=2;i<sieve.length;++i)
        {
            if(sieve[i]==true)
            {
                count+=1;
                for(int j=i+i;j<sieve.length;j+=i)
                {
                    sieve[j]=false;
                }
            }
        }
        return count;
    }
}s
