
class Element 
{
    int index;
    int difference;
    
    Element(int index, int difference)
    {
        this.index = index;
        this.difference = difference;
    }
}

class ElementComparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1, Element e2)
    {
        return Integer.compare(e1.difference,e2.difference);
    }
}

class Solution {
    public int twoCitySchedCost(int[][] costs) 
    {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(1,new ElementComparator());
        for(int i=0;i<costs.length;++i)
            pq.add(new Element(i,costs[i][0]-costs[i][1]));
            
        int totalcost = 0;
        
        int n = costs.length/2;
        while(n>0)
        {
            Element curr = pq.poll();
            totalcost += costs[curr.index][0];
            n-=1;
        }
        while(!pq.isEmpty())
        {
            Element curr = pq.poll();
            totalcost += costs[curr.index][1];
            
        }
        return totalcost;
    }
}
