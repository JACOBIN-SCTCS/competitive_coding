class Solution {
    
    int[][] dp;

    public int helper(int idx1, int idx2 , int[] nums1 , int[] nums2)
    {
        if(idx1==nums1.length || idx2 == nums2.length)
            return 0;
        
        if(dp[idx1][idx2] != 0)
            return dp[idx1][idx2];

        int ans = 0;

        ans = Math.max(ans , nums1[idx1] * nums2[idx2] + helper(idx1+1,idx2+1,nums1,nums2));
        ans = Math.max(ans , helper(idx1+1,idx2,nums1,nums2));
        ans = Math.max(ans , helper(idx1, idx2 +1 , nums1, nums2));
        dp[idx1][idx2] = ans;
        return dp[idx1][idx2];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) 
    {
        dp = new int[nums1.length][nums2.length];
        int n1_min=Integer.MAX_VALUE, n1_max = Integer.MIN_VALUE;
        int n2_min=Integer.MAX_VALUE, n2_max = Integer.MIN_VALUE;

        for(int i=0;i<nums1.length; ++i)
        {
            n1_min = Math.min(n1_min,nums1[i]);
            n1_max = Math.max(n1_max,nums1[i]);
        }
        for(int i=0;i<nums2.length;++i)
        {
            n2_min = Math.min(n2_min,nums2[i]);
            n2_max = Math.max(n2_max,nums2[i]);
        }

        // Had to refer editorial for edge case

        if(n1_max < 0 && n2_min > 0)
            return (n1_max*n2_min);

        if(n2_max < 0 && n1_min > 0)
            return (n2_max * n1_min);


        return helper(0,0,nums1,nums2);

    }
}
