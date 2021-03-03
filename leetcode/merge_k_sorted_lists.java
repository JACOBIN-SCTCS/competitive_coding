

class ListNodeComparator implements Comparator<ListNode>
{
    @Override
    public int compare(ListNode node1, ListNode node2) {
		
		if (node1.val < node2.val) 
            return -1; 
        if (node1.val > node2.val) 
            return 1; 
        return 0; 
	}
    
}



class Solution {
   
    public ListNode mergeKLists(ListNode[] lists)
    {
        
        if(lists.length==0)
            return null;
            
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length,new ListNodeComparator());
        
        for(int i=0;i<lists.length;++i)
        {
            if(lists[i]!=null)
            {
                q.add(lists[i]);
            }
        }
        
        
        ListNode head=null,ptr=null;
        while(!q.isEmpty())
        {
            ListNode curr = q.poll();
            
            if(head==null)
            {
                head= ptr = curr;
            }
            else
            {
                ptr.next=curr;
                ptr=curr;
            }
            
            ListNode newnode = curr.next;
            if(newnode!=null)
                q.add(newnode);
            
        }
        
        
        
        return head;
    }
}
