```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    int length(ListNode head)
    {
        ListNode ptr = head;
        int count=0;
        
        while(ptr!=null)
        {
            
            count+=1;
            ptr = ptr.next;
            
        }
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return null;
        
        int l1 = length(headA);
        int l2 = length(headB);
        ListNode A=headA,B=headB;
        
        if(l1>l2)
        {
            int abs = l1-l2;
            while(abs>0)
            {
                A=A.next;
                abs-=1;
            }
            
        }
        else if(l1<l2)
        {
             int abs = l2-l1;
            while(abs>0)
            {
                B=B.next;
                abs-=1;
            }
            
        }
        
        
        
        
        while(A!=null && B!=null)
        {
            if(A==B)
            {
                return A;
            }
            else
            {
                A = A.next;
                B=B.next;
            }
        }
        
        return null;
        
        
        
        
    }
}
```
