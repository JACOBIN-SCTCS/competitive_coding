class Solution {
    public int maxHeight(int[][] cuboids)
    {
        int[] dp = new int[cuboids.length];
        for(int[] cuboid: cuboids)
            Arrays.sort(cuboid);
        Arrays.sort(cuboids, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b)
            {
                int h = Integer.compare(a[2],b[2]);
                if(h==0)
                {
                    int w = Integer.compare(a[1],b[1]);
                    if(w==0)
                    {
                        return Integer.compare(a[0],b[0]);
                    }
                    else
                    {
                        return w;
                    }
                }
                else
                {
                    return h;
                }
            }
        });
        
        
        for(int i=0;i<=cuboids.length-1;i++)
            dp[i] = cuboids[i][2];
        
        for(int i=0;i<=cuboids.length-1;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                int[] cube1 = cuboids[i];
                int[] cube2 = cuboids[j];
                if(cube1[2]>=cube2[0]);
                {
                    if((cube2[0]<=cube1[0] && cube2[1]<=cube1[1]) || (cube2[1]<=cube1[0] && cube2[0]<=cube1[1]) )
                    {
                        dp[i] = Math.max(dp[i], dp[j] + cube1[2]);
                    }
                }
            }
        }
        int ans =0;
        for(int i=0;i<cuboids.length;++i)
            ans = Math.max(ans,dp[i]);
        
        return ans;
        
    }
}
