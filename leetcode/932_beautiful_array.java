class Solution {
    
    HashMap<Integer,int[]> dp = new HashMap<>();
    
    public int[] beautifulArray(int n) 
    {
        if(dp.containsKey(n))
            return dp.get(n);
        
        if(n<3)
        {
            int[] ret = new int[n];
            for(int i=1;i<=n;++i)
                ret[i-1] = i;
            
            return ret;
        }
        
        int[] left = beautifulArray((n+1)/2);
        int[] right = beautifulArray(n/2);
        int[] ret   = new int[n];
        
        
        int index =0;
        for(int i=0;i<right.length;++i)
        {
            ret[index] = (2*right[i]);
            index+=1;
        }
        for(int i=0;i<left.length;++i)
        {
            ret[index] = (2*left[i]-1);
            index+=1;    
        }
        dp.put(n,ret);
        return ret;
    }
}
