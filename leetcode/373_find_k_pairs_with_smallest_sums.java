class Element
{
    int num1;
    int num2;
  
    Element(int num1,int num2)
    {
        this.num1= num1;
        this.num2= num2;
    
    }
}

class CustomComparator implements Comparator<Element>
{
    @Override
    public int compare(Element e1, Element e2)
    {
        return (e1.num1+e1.num2)-(e2.num1+e2.num2);
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {
      
        int count=0;
        List<List<Integer>> ret_list = new ArrayList<List<Integer>>();
        PriorityQueue<Element> pq = new PriorityQueue<Element>(nums1.length*nums2.length, new CustomComparator());
        
        if(nums1.length==0 || nums2.length==0)
            return ret_list;
            
            
        for(int i=0;i<nums1.length;++i)
            for(int j=0;j<nums2.length;++j)
                pq.add(new Element(nums1[i],nums2[j]));
                

        while(count<k && !pq.isEmpty())
        {
            Element curr = pq.remove();
            List<Integer> list = new ArrayList<Integer>();
            list.add(curr.num1);
            list.add(curr.num2);
            ret_list.add(list);
            count+=1;
        }
       return ret_list;
    }
}
