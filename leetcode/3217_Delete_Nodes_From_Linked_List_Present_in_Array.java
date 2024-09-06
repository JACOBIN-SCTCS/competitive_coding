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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        HashSet<Integer> nums_set = new HashSet<>();
        for(int i=0; i < nums.length; ++i)
            nums_set.add(nums[i]);
        
        ListNode ans = head;
        ListNode ptr = head;
        ListNode prev = null;

        while(ptr!=null)
        {
            if(nums_set.contains(ptr.val))
            {
                if(prev == null)
                {
                    ans = ptr.next;
                    prev = null;
                    ptr = ptr.next;
                }
                else
                {
                    prev.next = ptr.next;
                    ptr = ptr.next;
                }
            }
            else
            {
                prev = ptr;
                ptr = ptr.next;
            }
        }
        return ans;
    }
}
