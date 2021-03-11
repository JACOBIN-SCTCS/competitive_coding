class Solution {
    public ListNode rotateRight(ListNode head, int k)
    {
        if(head==null)
            return null;
        
        ListNode ptr=head;
        int length=1;
        
        while(ptr.next!=null)
        {
            
            ptr=ptr.next;
            length+=1;
        }
        
        ptr.next=head;
        k = k%length;
        ptr=head;
        int i=1;
        
        while(i<=(length-k-1))
        {
            ptr=ptr.next;
            i+=1;
        }
        
        head=ptr.next;
        ptr.next=null;
      
        return head;
        
        
        
    }
}
