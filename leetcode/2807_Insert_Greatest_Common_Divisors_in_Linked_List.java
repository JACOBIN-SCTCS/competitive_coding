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
    
    public int gcd(int a, int b)
    {
        if(a==0)    
            return b;
        else
            return gcd(b%a, a);
        
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        while(ptr1 != null && ptr2 !=null)
        {
            ListNode newNode = new ListNode();
            newNode.val = gcd(ptr1.val, ptr2.val);
            newNode.next = ptr2;
            ptr1.next = newNode;

            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return head;
    }
}
