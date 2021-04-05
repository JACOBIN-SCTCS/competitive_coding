
class Element
{
    ListNode node;
    int index;
    
    Element(ListNode node,  int index)
    {
        this.node=node;
        this.index=index;
    }

}


class Solution
{
    public int[] nextLargerNodes(ListNode head) 
    {
        ListNode ptr = head;
        int size=0;
        while(ptr!=null)
        {
            size+=1;
            ptr=ptr.next;
            
        }

        int[] ret = new int[size];
        
        
        Stack<Element> st = new Stack<>();
        ptr = head;
        
        for(int i=0;i<size;++i)
        {
            Element e = new Element(ptr,i);
            while(!st.isEmpty() && e.node.val > st.peek().node.val )
            {
                Element popped = st.peek();
                st.pop();
                ret[popped.index] = ptr.val; 
            }
            st.push(e);
            ptr=ptr.next;
        }
        return ret;
        
    }
}
