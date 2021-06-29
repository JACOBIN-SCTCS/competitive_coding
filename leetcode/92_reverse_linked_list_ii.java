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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode beforeptr = null;
        ListNode listptr = head;
        int count=1;
        while(count<left)
        {
            beforeptr = listptr;
            listptr = beforeptr.next;
            count+=1;
        }
        ListNode rstart =listptr;
        ListNode rbefore = null;
        while(count<=right)
        {
            ListNode fptr = listptr.next;
            listptr.next  = rbefore;
            rbefore = listptr;
            listptr = fptr;
            count+=1;
        }
        rstart.next = listptr;
        if(left==1)
        {
            head = rbefore;
            return head;
        }
        beforeptr.next = rbefore;
        return   head;
            
    }
}
