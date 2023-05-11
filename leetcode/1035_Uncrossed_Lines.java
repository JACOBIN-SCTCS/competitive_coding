class Solution {
    
    int[][] dp;
    
    public int helper(int[] nums1, int[] nums2, int ptr1, int ptr2)
    {
        if(ptr1 >= nums1.length || ptr2 >= nums2.length)
            return 0;
        if(dp[ptr1][ptr2] != -1)
            return dp[ptr1][ptr2];
        
        int ans = 0;

        ans = Math.max(ans,helper(nums1,nums2,ptr1+1,ptr2));
        ans = Math.max(ans,helper(nums1,nums2,ptr1,ptr2+1));
        ans = Math.max(ans,helper(nums1,nums2,ptr1+1,ptr2+1));
        
        for(int i = ptr1;i<nums1.length;++i)
        {
            if(nums1[i]==nums2[ptr2])
            {
                ans = Math.max(ans,1 + helper(nums1,nums2,i+1,ptr2+1));
            }
        }

        for(int i = ptr2;i<nums2.length;++i)
        {
            if(nums1[ptr1]==nums2[i])
            {
                ans = Math.max(ans,1 + helper(nums1,nums2,ptr1+1,i+1));
            }
        }
        dp[ptr1][ptr2] = ans;
        return ans;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) 
    {
        dp = new int[nums1.length][nums2.length];
        for(int i=0;i<nums1.length;++i)
            Arrays.fill(dp[i],-1);
        
        return helper(nums1,nums2,0,0);
    }
}
