class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int ans =  Integer.MAX_VALUE;
        int n = blocks.length();

        int count = 0;
        for(int i=0; i < k  ; ++ i)
        {
            if(blocks.charAt(i) == 'W')
                count+=1;
        }

        ans = Math.min(ans,count);

        for(int i=k; i < n; ++i)
        {
            if(blocks.charAt(i-k) == 'W')
                count-=1;
            if(blocks.charAt(i) == 'W')
                count+=1;

            ans = Math.min(ans,count);
        }


        return ans;
    }
}
