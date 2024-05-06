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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode ptr = head;
        while(ptr!=null)
        {
            st.push(ptr);
            ptr = ptr.next;
        }

        ptr = st.peek();
        st.pop();
        int max_element = ptr.val;
        while(!st.isEmpty())
        {
            ListNode current_top = st.peek();
            st.pop();
            if(current_top.val >= max_element)
            {
                max_element = current_top.val;
                current_top.next = ptr;
                ptr = current_top;
            }
        }
        return ptr;
    }
}
