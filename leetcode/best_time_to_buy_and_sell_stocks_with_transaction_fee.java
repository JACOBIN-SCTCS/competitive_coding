class Solution {
    public int maxProfit(int[] prices, int fee) 
    {
        if(prices.length<=1)
            return 0;
        
        int[] hold = new int[prices.length];
        int[] nothold = new int[prices.length];
        
        hold[0] = -prices[0]-fee;
        nothold[0]=0;
        
        
        for(int i=1;i<prices.length;++i)
        {
            hold[i] = Math.max(hold[i-1],(nothold[i-1]-prices[i]-fee));
            nothold[i] = Math.max(nothold[i-1],hold[i-1]+prices[i]);
            
        }
 
        return nothold[prices.length-1];
        
    }
}
