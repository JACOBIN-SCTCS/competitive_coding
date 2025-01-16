class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int ans = 0;
        int m = nums1.length;
        int n = nums2.length;

        if(m%2 == 1)
        {
            for(int i=0; i < n; ++i)
                ans = ans ^ nums2[i];

        }
        if(n%2 == 1)
        {
            for(int i=0; i < m ; ++i)
                ans = ans ^ nums1[i];
        }
        return ans;

    }
}
