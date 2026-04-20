class Solution {
    public int maxDistance(int[] colors) {
        int[] left = new int[101];
        int[] right = new int[101];

        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        for(int i= 0; i < colors.length; ++i) {
            if(left[colors[i]]== -1)   
                left[colors[i]] = i;
            right[colors[i]] = i;
        }

        int ans = 1;
        for(int i=0; i <=100; ++i) {
            for(int j=0; j<=100; ++j) {
                if(i!=j && left[i] != -1 && right[j] != -1)
                {
                    ans = Math.max(ans, right[j]-left[i]);
                }
            }
        }
        return ans; 
    }
}
