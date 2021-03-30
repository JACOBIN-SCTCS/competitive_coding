class Solution 
{
    public int maxEnvelopes(int[][] envelopes)
    {
                
        Arrays.sort(envelopes, new Comparator<int[]>(){
           
            @Override
            public int compare(int [] a ,  int[] b)
            {
               if(a[0]!=b[0])
                   return a[0]-b[0];
                
               else
               {
                   return a[1]-b[1];
               }
            }
        });
        
        int len = envelopes.length;
        
        int[] lis = new int[len];
        Arrays.fill(lis,1);
        int[] arr = new int[len];
        
        for(int i=0;i<len;++i)
            arr[i]=envelopes[i][1];
        
        
        for(int i=0;i<len;++i)
        {
            for(int j=0;j<i;++j)
            {
                if(arr[j]<arr[i] && envelopes[j][0]<envelopes[i][0])
                {
                    lis[i] = Math.max(lis[j]+1,lis[i]);
                }
            }
        }
        
        int maximum = Integer.MIN_VALUE;
        for(int i=0;i<len;++i)
        {
            maximum = Math.max(maximum,lis[i]);
        }
        
        return maximum;
        
        
        
    }
}
