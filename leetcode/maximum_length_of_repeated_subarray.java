class Solution 
{
    int maximum = Integer.MIN_VALUE;
    
    public int findLength(int[] A, int[] B) 
    {
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i=A.length-1;i>=0; i--)
        {
            for(int j=B.length-1;j>=0 ; j--)
            {
                if(A[i]==B[j])
                {
                    dp[i][j] = dp[i+1][j+1]+1;
                    maximum = Math.max(maximum,dp[i][j]);
                }
            }
        }
        return maximum==Integer.MIN_VALUE?0:maximum;
        
    }
}
