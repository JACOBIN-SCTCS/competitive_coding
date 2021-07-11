class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    
    public MedianFinder() {
        
        maxheap = new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
        minheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) 
    {
        if(maxheap.isEmpty() || maxheap.peek()>=num)
        {
            maxheap.add(num);
        }        
        else
        {
            minheap.add(num);
            
        }
        
        if(minheap.size() > maxheap.size())
        {
            while(minheap.size()>maxheap.size())
            {
                maxheap.add(minheap.poll());
            }
        }
        else if(maxheap.size()> (minheap.size()+1))
        {
            minheap.add(maxheap.poll());
        }
    
            
    }
    
    public double findMedian() 
    {
        double result = 0.0;
        if(minheap.size()==maxheap.size())
        {
            double num1 = minheap.peek();
            double num2 = maxheap.peek();
            result =(num1+num2)/2;
        }
        else
        {
            result = maxheap.peek();
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
