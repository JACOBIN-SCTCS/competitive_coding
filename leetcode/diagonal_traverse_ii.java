class Element
{
    int sum;
    int row;
    int ele;
    
    Element(int sum, int row,int ele)
    {
        this.sum=sum;
        this.row=row;
        this.ele=ele;
    }
}

class ElementComparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1, Element e2)
    {
        if(e1.sum<e2.sum || ((e1.sum==e2.sum)&&(e1.row>e2.row)) )
            return -1;
        if(e1.sum>e2.sum || ((e1.sum==e2.sum)&&(e1.row<e2.row)))
            return 1;
        
        return 0;
    }
}


class Solution 
{
    public int[] findDiagonalOrder(List<List<Integer>> nums)
    {
        List<Element> list = new ArrayList<Element>();
        for(int i=0;i<nums.size();++i)
        {
            for(int j=0;j<nums.get(i).size();++j)
            {
                list.add(new Element(i+j,i,nums.get(i).get(j)));
            }
                
        }
        
        Collections.sort(list,new ElementComparator());
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();++i)
        {
            ret[i] = list.get(i).ele;
        }
        return ret;
    }
}
