class Solution 
{
    public int numRescueBoats(int[] people, int limit)
    {
        
        Arrays.sort(people);
        int front=0;
        int back = people.length-1;
        int boats =0;
        
        while(front<=back)
        {
            if(people[front]+people[back]<=limit)
            {
                front+=1;
                back-=1;
            }
            else
            {
                back-=1;
            }
            boats+=1;
                
        }
        return boats;
    }
}
