```
class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        if(head==null)
            return null;
        
        if(head.next!=null)
        {
            int tmp  = head.val;
            head.val = head.next.val;
            head.next.val = tmp;
            
            head.next.next = swapPairs(head.next.next);
            
        }
        return head;
    }
}
```
