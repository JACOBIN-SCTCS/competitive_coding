class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);
        int current_fuel = startFuel;
        int refuel = 0;
        
        for(int[] station : stations)
        {
            while(current_fuel < station[0])
            {
                if(pq.isEmpty())
                    return -1;
                current_fuel += pq.poll();
                refuel+=1;
            }
            pq.add(station[1]);
        }
        
        while(current_fuel<target)
        {
            if(pq.isEmpty())
                return -1;
            current_fuel += pq.poll();
            refuel+=1;
        }
        return refuel;
    }
}
