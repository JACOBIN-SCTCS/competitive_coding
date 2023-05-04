class Solution {
    public String predictPartyVictory(String senate) 
    {
       // Had to refer editorial for efficient solution.
       Queue<Integer> rqueue = new LinkedList<Integer>();
       Queue<Integer> dqueue = new LinkedList<Integer>();
       int n = senate.length();

       for(int i=0;i<senate.length();++i)
       {
           if(senate.charAt(i)=='R')
            rqueue.add(i);
           else
            dqueue.add(i);     
       }  

        while(rqueue.size() >0 && dqueue.size() > 0)
        {
            int rindex = rqueue.poll();
            int dindex = dqueue.poll();

            if(rindex > dindex)
            {
                dqueue.add(dindex + n);
            }
            else
            {
                rqueue.add(rindex + n);
            }
        }

        if(rqueue.size() > 0)
            return new String("Radiant");
        else
            return new String("Dire");
    }
}
