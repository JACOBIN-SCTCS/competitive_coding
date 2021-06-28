class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;
        int max_right = 0;
        int[]  maxright = new int[height.length];
        
        for(int i=n-1;i>=0;i--)
        {
            maxright[i] = Math.max(max_right,height[i]);
            max_right = Math.max(height[i],max_right);
        }
        int max_left =0;
        int ans =0;
        for(int i=0;i<n;++i)
        {
            max_left = Math.max(max_left,height[i]);
            if(Math.min(max_left,maxright[i])>=height[i])
            {
                ans = ans + (Math.min(max_left,maxright[i])-height[i]);
            }
        }
        return ans;
    }
}
