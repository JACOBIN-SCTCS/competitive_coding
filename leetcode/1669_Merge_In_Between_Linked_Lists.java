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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode end_list2 = list2;
        while(end_list2.next != null)
            end_list2 = end_list2.next;
        
        ListNode aptr = list1;
        ListNode prev_aptr = aptr;
        for(int i=0 ; i < a ; ++i)
        {
            prev_aptr = aptr;
            aptr = aptr.next;
        }
        ListNode bptr = aptr;
        for(int i=0; i <= (b-a); ++i)
            bptr = bptr.next;
        
        prev_aptr.next = list2;
        end_list2.next = bptr;
        return list1;
    }
}
