class Solution {
    class Element
    {
        int val;
        int index;

        Element(int val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element a, Element b)
            {
                if(a.val == b.val)
                    return (a.index-b.index);
                return a.val-b.val;
            }
        });

        for(int i=0; i < nums.length; ++i)
            pq.add(new Element(nums[i],i));

        for(int i=0; i < k ; ++i)
        {
            Element polled = pq.poll();
            int multiplied_value = multiplier * nums[polled.index];
            nums[polled.index] = multiplied_value;
            pq.add(new Element(multiplied_value, polled.index));
        }
        return nums;

    }
}
