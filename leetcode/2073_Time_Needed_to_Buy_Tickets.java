class Person
{
    int pos;
    int tickets;

    Person(int pos, int tickets)
    {
        this.pos = pos;
        this.tickets = tickets;
    }
}

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        Queue<Person> q = new LinkedList<>();
        int ans = 0;
        for(int i=0; i < tickets.length ; ++i)
            q.add(new Person(i,tickets[i]));

        while(!q.isEmpty())
        {
            Person p = q.poll();
            p.tickets = p.tickets - 1;
            ans+=1;
            if(p.tickets == 0)
            {
                if(p.pos == k)
                    return ans;
            }
            else
            {
                q.add(p);
                
            }
        }
        return ans;
        
    }
}
