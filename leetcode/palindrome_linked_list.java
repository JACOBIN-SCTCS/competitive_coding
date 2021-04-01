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
class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        Stack<ListNode> st = new Stack<>();
        ListNode ptr = head;
        
        while(ptr!=null)
        {
            st.push(ptr);
            ptr=ptr.next;
        }
        
        ptr = head;
        while(ptr!=null)
        {
            if(ptr.val!=st.peek().val)
                return false;
            st.pop();
            ptr=ptr.next;
        }
        
        return true;
        
    }
}
