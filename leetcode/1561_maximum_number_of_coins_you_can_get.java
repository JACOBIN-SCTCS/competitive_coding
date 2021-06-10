class Solution {
    public int maxCoins(int[] piles) 
    {
        Arrays.sort(piles);
        int i =0;
        int j = piles.length-1;
        int ans = 0;
        
        while(i<j)
        {
            i++;
            j-=1;
            ans = ans + piles[j];
            j-=1;
            
            
        }
        return ans;
             
    }
}
