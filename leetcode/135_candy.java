class Solution {
    public int candy(int[] ratings) 
    {
        int[] right = new int[ratings.length];
        int[] left = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        
        for(int i=1;i<ratings.length;++i)
        {
            if(ratings[i]>ratings[i-1])
            {
                left[i] = left[i-1]+1;
            }
        
        }
        for(int i=ratings.length-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                right[i] = right[i+1]+1;
            }
        }
        int ans = 0;
        for(int i=0;i<ratings.length;++i)
        {
            ans = ans + Math.max(left[i],right[i]);
        }
        return ans;
    }
}
