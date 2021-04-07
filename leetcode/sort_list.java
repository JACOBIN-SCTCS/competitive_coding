/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    
    public ListNode getMiddle(ListNode head)
    {
        ListNode midPrev = head;
        while (head != null && head.next != null) {
            midPrev = (midPrev == head) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    
    public ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode start = new ListNode(0,null);
        ListNode tail = start;
        
        while(list1!=null && list2!=null)
        {
            if(list1.val<= list2.val)
            {
                tail.next = list1;
                tail=tail.next;
                list1 = list1.next;
            }
            else
            {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        
        tail.next = ( (list1==null)?list2:list1);
        return start.next;

        
    }
    
    
    
    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode middle = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        ListNode merged = merge(left,right);
        return merged;
    }
}
