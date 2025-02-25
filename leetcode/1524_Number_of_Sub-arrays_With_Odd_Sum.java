class Solution {
    public int numOfSubarrays(int[] arr) 
    {
        // Got hint from editorial
        int mod = 1000000007;
        int oddEndingCount = 0;
        int evenEndingCount = 1;
        int prefixsum = 0 ;
        int res = 0;

        for(int i=0; i < arr.length; ++i)
        {
            int rem = arr[i] % 2;
            prefixsum = (prefixsum + rem) % mod;
            if(prefixsum %2 == 1)
            {
                res = (res + evenEndingCount)%mod;
                oddEndingCount+=1;
            }
            else
            {
                res = (res + oddEndingCount)%mod;
                evenEndingCount+=1;
            }
        }
        return res;        
    }
}
