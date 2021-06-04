class Element
{
    int ele;
    int idx;
    
    Element(int ele, int idx)
    {
        this.ele = ele;
        this.idx = idx;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2)
            {
                return Integer.compare(e2.ele,e1.ele);
            }
        });
        
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<k;++i)
            pq.add(new Element(nums[i],i));
        
        ans[0] = pq.peek().ele;
        for(int i=k;i<nums.length;++i)
        {
            while(!pq.isEmpty() && pq.peek().idx<=i-k)
            {
                Element ele = pq.poll();
            }
            pq.add(new Element(nums[i],i));
            ans[i-k+1] = pq.peek().ele;
        }
        
        return ans;
    }
}
