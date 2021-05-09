class Solution {
    public boolean isPossible(int[] target) 
    {
        
        
        if(target==null || target.length<1)
            return true;
        if(target.length==1)
        {
            if(target[0]==1)
                return true;
            else
                return false;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{return (b-a);});
        long sum=0;
        for(int ele:target)
        {
            sum+=ele;
            pq.add(ele);
        }
        while(!pq.isEmpty())
        {
            int top = pq.remove();
            sum-=top;
            if(top==1 || sum==1)
                return true;
            
            if(top<sum || top%sum==0 || sum==0)
                return false;
            top%=sum;
            sum+=(top);
            pq.add(top);
        }
        return true;
    }
}
