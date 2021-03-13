class Solution {
    public int numFactoredBinaryTrees(int[] arr) 
    {
        long res=0L, mod = (long)Math.pow(10,9)+7;
        
        HashMap<Integer,Long> dp = new HashMap<>();
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;++i)
        {
            dp.put(arr[i],1L);
            for(int j=0;j<i;++j)
            {
                if((arr[i]%arr[j]==0)&&( dp.containsKey(arr[i]/arr[j]) ) )
                {
                    dp.put(arr[i], (dp.get(arr[i])+ (dp.get(arr[j]))*(dp.get(arr[i]/arr[j])))%mod);
                }
            }
        }
        
    
        
        for(long value:dp.values())
        {
            res = (res+value)%mod;
        }
        
        return (int)res;
        
    }
}
