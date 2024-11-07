class Solution {
    public int largestCombination(int[] candidates) {
        
        int[] hashtable = new int[24];
        
        for(int i=0; i < candidates.length; ++i)
        {
            int num = candidates[i];
           
            for(int j=0; j < 24 ; ++j)
            {
                if((num & 1 ) == 1)
                    hashtable[j] +=1;
                
                if(num <= 0)
                    break;
                num >>= 1;
            }
        }
        int ans = 0;
        for(int i=0; i < 24; ++i)
        {
            ans = Math.max(ans,hashtable[i]);
        }
        return ans;
    }

}
