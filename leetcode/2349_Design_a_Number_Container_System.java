class NumberContainers {

    // Referred editorial for efficient approach
    
    HashMap<Integer,Integer> indexMapper;
    HashMap<Integer,PriorityQueue<Integer>> numIndex;

    public NumberContainers() {
        indexMapper = new HashMap<Integer,Integer>();
        numIndex = new HashMap<Integer,PriorityQueue<Integer>>();    
    }
    
    public void change(int index, int number) {
        PriorityQueue<Integer> pq = numIndex.getOrDefault(number,null);
        if(pq == null)
        {
            pq = new PriorityQueue<Integer>();
        }
        pq.add(index);
        numIndex.put(number,pq);

        indexMapper.put(index,number);
    }
    
    public int find(int number) {
        if(!numIndex.containsKey(number))
            return -1;
        
        PriorityQueue<Integer> pq = numIndex.get(number);
        int ans = -1;
        while(!pq.isEmpty())
        {
            int ele = pq.peek();
            if(number == indexMapper.get(ele))
            {
                ans = ele;
                break;
            }
            else
            {
                pq.poll();
            }
        }
        return ans;

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
