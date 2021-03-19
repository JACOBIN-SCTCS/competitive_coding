class Solution 
{
    public ListNode partition(ListNode head, int x) 
    {
        ListNode bhead = new ListNode(0);
        ListNode ahead = new ListNode(0);
        ListNode b = bhead;
        ListNode a = ahead;
        
        while(head!=null)
        {
            if(head.val<x)
            {
                b.next = new ListNode(head.val);
                b=b.next;
            }
            else
            {
                a.next= new ListNode(head.val);
                a=a.next;
            }
            head = head.next;
        }
        b.next=ahead.next;
        return bhead.next;
    }
}
