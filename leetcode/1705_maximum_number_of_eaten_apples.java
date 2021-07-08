class Apple
{
    int count;
    int deadline;
    
    Apple(int count, int deadline)
    {
        this.count = count;
        this.deadline = deadline;
    }
}

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        
        int total=0;
        int day=0;
        PriorityQueue<Apple> pq = new PriorityQueue<Apple>(new Comparator<Apple>(){
            @Override
            public int compare(Apple a1, Apple a2)
            {
               return Integer.compare(a1.deadline,a2.deadline);
            }
        });
        
        for(int i=0;i<apples.length;++i)
        {
            if(apples[i]!=0)
                pq.add(new Apple(apples[i],i+days[i]));
            if(!pq.isEmpty())
            {
                while(!pq.isEmpty() && pq.peek().deadline<=day)
                    pq.poll();
                if(!pq.isEmpty())
                {
                    Apple curr = pq.poll();
                    curr.count-=1;
                    total+=1;
                    if(curr.count>0)
                        pq.add(curr);
                }
            }
            day+=1;
        }
        while(!pq.isEmpty())
        {
            Apple curr = pq.poll();
            if(curr.deadline<=day)
                continue;
            curr.count-=1;
            total+=1;
            if(curr.count>0)
                pq.add(curr);
            day+=1;
        }
        return total;
    }
}
