class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(-1,head);
        
        ListNode slowptr = dummy;
        ListNode fastptr = dummy;
        int idx=n;
        
        if(head.next==null)
        {
            return null;
        }
        while(idx!=0)
        {
            fastptr = fastptr.next;
            idx-=1;
        }
        
        while(fastptr.next!=null)
        {
            fastptr=fastptr.next;
            slowptr = slowptr.next;
        }
        
        slowptr.next = slowptr.next.next;
        return dummy.next;
        
    }
}
