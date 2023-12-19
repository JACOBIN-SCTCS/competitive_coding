class Solution {
    public int[][] imageSmoother(int[][] img) 
    {
        int[][] ans = new int[img.length][img[0].length];
        for(int i=0; i < img.length; ++i)
        {
            for(int j=0; j < img[0].length; ++j)
            {
                int num_elements = 0;
                int sum = 0;
                for(int k=Math.max(i-1,0); k <= Math.min(i+1,img.length-1);++k)
                {
                    for(int l = Math.max(j-1,0); l <= Math.min(j+1,img[0].length-1);++l)
                    {
                        sum = sum + img[k][l];
                        num_elements +=1;
                    }
                }
                ans[i][j] = sum / num_elements;
            }
        } 
        return ans;
    }
}
