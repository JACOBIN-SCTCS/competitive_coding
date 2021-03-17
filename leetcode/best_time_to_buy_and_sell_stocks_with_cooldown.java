class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices.length<=1)
            return 0;
        
        int[] hold = new int[prices.length];
        int[] nhold = new int[prices.length];
        
        hold[0]=-prices[0];
        nhold[0]=0;
        
        for(int i=1;i<prices.length;++i)
        {
            nhold[i] = Math.max(nhold[i-1],hold[i-1]+prices[i]);
            if(i>1)
                hold[i] =Math.max(hold[i-1],nhold[i-2]-prices[i]);
            else
                hold[i] =Math.max(hold[i-1],-prices[i]);
        }
        return nhold[prices.length-1];
    }
}
