class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int[] ans = new int[code.length];
        int sum = 0;

        if(k==0)
            return ans;
        
        for(int i=0; i < code.length; ++i)
        {
            if (k > 0)
            {
                sum = 0;
                for(int j=1; j <= k ; ++j)
                {
                    
                    sum = sum + (code[(i+j)%code.length]);
                }
                ans[i] = sum;
            }
            else
            {
                sum = 0;
                for(int j=i-Math.abs(k); j < i ; ++j)
                {
                    
                    sum = sum + (code[(j+code.length)%code.length]);
                }
                ans[i] = sum;
            }
            
           
        }
        return ans;
    }
}
