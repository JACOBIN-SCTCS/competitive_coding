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
import java.util.Random ;
class Solution {

    ListNode h = null;
    
    public Solution(ListNode head) 
    {
            this.h = head;
    }
    
    public int getRandom() 
    {
        int prob = 1;
        ListNode ans = h;
        ListNode ptr = ans;
        
        while(ptr!=null)
        {
            if(Math.random() < 1.0/prob)
            {
                ans = ptr;
                
            }
            prob+=1;
            ptr = ptr.next;
        }
        return ans.val;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
