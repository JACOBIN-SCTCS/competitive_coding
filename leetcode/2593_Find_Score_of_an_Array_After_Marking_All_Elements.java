

class Solution {
    
    class Element
    {
        int index;
        int val;

        Element(int index, int val)
        {
            this.index = index;
            this.val = val;
        }
    }
    
    public long findScore(int[] nums) {
        

        PriorityQueue<Element> pq = new PriorityQueue<Element>(1, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2)
            {
                if(e1.val == e2.val)
                    return e1.index - e2.index;
                else
                    return e1.val - e2.val;
            }
        });
        for(int i=0; i < nums.length; ++i)
            pq.add(new Element(i,nums[i]));
        
        int[] marked = new int[nums.length];
        long score = 0;
        while(!pq.isEmpty())
        {
            Element polled = pq.poll();
            if(marked[polled.index]==1)
                continue;
            score = score + polled.val;
            marked[polled.index] = 1;
            if(polled.index-1 >=0)
                marked[polled.index-1] = 1;
            if(polled.index + 1 < marked.length)
                marked[polled.index+1] = 1;
    

        }
        return score;
    }   
}
