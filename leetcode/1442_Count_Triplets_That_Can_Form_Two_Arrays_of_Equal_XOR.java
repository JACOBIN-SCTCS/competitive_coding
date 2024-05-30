class Solution {
    public int countTriplets(int[] arr) 
    {
        int n = arr.length;
        int ans =0;

        int[] prefixsum = new int[n+1];
       
        for(int i=0; i < n; ++i)
        {
            prefixsum[i+1] = prefixsum[i] ^ arr[i];
        }

        for(int i=0; i < n; ++i)
        {
            for(int j=i+1; j < n ; ++j)
            {
                if((prefixsum[j+1] ^ prefixsum[i]) == 0)
                    ans +=(j-i);
            }
        }    
        return ans;
        
    }
}
