class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int pointer = 0;
        int start_idx = 0;
        int totalgas = 0;
        while(pointer < gas.length)
        {
            totalgas = totalgas + (gas[pointer] - cost[pointer]);
            if(totalgas<0)
            {
                totalgas  = 0;
                if((pointer+1)==gas.length)
                    return -1;
                start_idx = (pointer+1);
            }
            pointer+=1;
        }

        for(int i=0;i<start_idx;++i)
        {
            totalgas  = totalgas + (gas[i]-cost[i]);
            if(totalgas<0)
                return -1;
        }
        return start_idx;

    }
}
