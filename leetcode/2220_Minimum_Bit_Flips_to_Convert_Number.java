class Solution {
    public int minBitFlips(int start, int goal) 
    {
        int num = start ^ goal;
        int ans = 0;

        while(num > 0)
        {
            if((num & 1) > 0)
                ans+=1;
            num >>=1;

        }    
        return ans;
    }
}
