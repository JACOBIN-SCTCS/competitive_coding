class SmallestInfiniteSet {

    PriorityQueue<Integer> q;

    public SmallestInfiniteSet() 
    {
        q= new PriorityQueue<Integer>();
        for(int i=1;i<=1000;++i)
            q.add(i);
               
    }
    
    public int popSmallest() 
    {
       return q.poll();

    }
    
    public void addBack(int num) {
        if(!q.contains(num))
            q.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
