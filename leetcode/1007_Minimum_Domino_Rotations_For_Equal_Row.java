class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] top = new int[7];
        int[] bottom = new int[7];
        int[] samecount = new int[7];


        for(int i=0; i < tops.length; ++i)
        {
            if(tops[i] != bottoms[i])
            {
                top[tops[i]] +=1;
                bottom[bottoms[i]] += 1;
            }
            else
            {
                samecount[tops[i]] += 1;
            }
            
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1 ; i <= 6 ; ++i)
        {
            System.out.println(top[i] + "  " + bottom[i]);

            if(top[i] + bottom[i] + samecount[i] == tops.length)
            {
                ans = Math.min(ans, Math.min(top[i],bottom[i]));
            }
        }
        if(ans == Integer.MAX_VALUE)
            return -1;

        return ans;

    }
}
