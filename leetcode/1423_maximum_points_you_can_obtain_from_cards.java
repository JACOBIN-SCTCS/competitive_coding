class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int[] prefix = new int[k];
        int[] suffix = new int[k];
        int n = cardPoints.length-1;
        
        prefix[0]=cardPoints[0];
        suffix[0] = cardPoints[n];
        
        for(int i=1;i<k;++i)
        {
            prefix[i] = prefix[i-1] + cardPoints[i];
            suffix[i] = suffix[i-1] + cardPoints[n-i];
        }
        
        int res = Math.max(prefix[k-1],suffix[k-1]);
        for(int i=0;i<k-1;++i)
        {
            res = Math.max(res,prefix[i]+suffix[k-i-2]);
        }
        
        return res;
    }
}
