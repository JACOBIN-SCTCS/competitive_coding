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
    public int pairSum(ListNode head) 
    {
        Stack<Integer> st =new Stack<Integer>();
        ListNode tmp = head;
        int length = 0;
        
        while(tmp!=null)
        {
            length+=1;
            st.push(tmp.val);
            tmp = tmp.next;
        }    

        int ans = 0;
        tmp =head;
        for(int i=0;i<(length/2);++i)
        {
            ans =Math.max(ans,tmp.val+st.peek());
            st.pop();
            tmp = tmp.next;
        }
        return ans;
    }
}
