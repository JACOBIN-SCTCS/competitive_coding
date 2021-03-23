
class Solution {
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        
        ListNode odd=head,even = head.next;
        ListNode evenptr = even;
        ListNode oddptr = odd;
        

        
        while(evenptr!=null && evenptr.next!=null )
        {
            oddptr.next = evenptr.next;
            oddptr = oddptr.next;
            evenptr.next = oddptr.next;
            evenptr=evenptr.next;
        }
        
        oddptr.next = even;
        return odd;
    }
}
