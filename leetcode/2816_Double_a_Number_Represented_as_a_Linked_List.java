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
    public ListNode doubleIt(ListNode head) 
    {
        int carry = 0;
        Stack<ListNode> st = new Stack<>();
        ListNode ptr = head;

        while(ptr != null)
        {
            st.push(ptr);
            ptr = ptr.next;
        }

        while(!st.isEmpty())
        {
            ListNode top_element = st.peek();
            st.pop();
            top_element.val = 2*top_element.val + carry ;

            int lsd = top_element.val % 10;
            int msd = top_element.val/10;
            top_element.val = lsd;
            carry = msd;
        }

        if(carry > 0)
        {
            ListNode msd = new ListNode(carry);
            msd.next = head;
            head = msd;
        }
        return head;
    }
}
