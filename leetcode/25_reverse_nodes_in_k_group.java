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
    public ListNode reverseKGroup(ListNode head, int k)
    {
        if(head==null)
            return head;
        int length= 0;
        ListNode ptr = head;
        while(ptr!=null)
        {
            length+=1;
            ptr=ptr.next;
        }
        if(length<k)
            return head;
        
        ListNode prev = null;
        ptr = head;
        int elements =0;
        while(elements<k)
        {
            elements+=1;
            ListNode temp = ptr.next;    
            ptr.next=prev;
            prev = ptr;
            ptr=temp;
        }
        head.next = reverseKGroup(ptr,k);
        return prev;
    }
}
