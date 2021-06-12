class Solution {
    public double averageWaitingTime(int[][] customers) 
    {
        long waiting_time = 0;
        long current_time = 0;
        for(int[] customer: customers)
        {
            if(current_time<customer[0])
            {
                current_time = customer[0]+customer[1];
                waiting_time += customer[1];
            }
            else
            {
                current_time += customer[1];
                waiting_time = waiting_time + (current_time-customer[0]);
                
            }
        }
        
        double ans = ((double)(waiting_time)/(customers.length));
        return ans;
    }
}
