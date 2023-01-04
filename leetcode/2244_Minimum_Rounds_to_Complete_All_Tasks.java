class Solution {
    public int minimumRounds(int[] tasks)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int task : tasks)
        {
            if(!map.containsKey(task))
            {
                map.put(task,1);
            }
            else
            {
                int taskcount = map.get(task);
                taskcount+=1;
                map.put(task,taskcount);
            }
        }
        Iterator it = map.entrySet().iterator();
        int count = 0;
        for(int key : map.keySet())
        {
            int value = map.get(key);
            if(value==1)
                return -1;

            if(value%3==0)
                count = count + (value/3);     
            else
                count = count + (value/(3)) + 1;
        }   
        return count;    
    }
}
