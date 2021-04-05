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
    public int numComponents(ListNode head, int[] G)
    {
        int components =0 ;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int val:G)
            set.add(val);
        
        ListNode ptr=head;
        
        while(ptr!=null)
        {
            if(set.contains(ptr.val))
            {
                components+=1;
                set.remove(ptr.val);
                ptr=ptr.next;
                while(ptr!=null && set.contains(ptr.val))
                {
                    set.remove(ptr.val);
                    ptr=ptr.next;
                    
                }
            }
            else
            {
                ptr=ptr.next;
            }
        }
        components+= set.size();
        return components;
        
    }
}
